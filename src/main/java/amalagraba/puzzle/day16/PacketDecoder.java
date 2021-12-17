package amalagraba.puzzle.day16;

import amalagraba.puzzle.day16.operators.EqualToPacket;
import amalagraba.puzzle.day16.operators.GreaterThanPacket;
import amalagraba.puzzle.day16.operators.LessThanPacket;
import amalagraba.puzzle.day16.operators.MaxPacket;
import amalagraba.puzzle.day16.operators.MinPacket;
import amalagraba.puzzle.day16.operators.ProductPacket;
import amalagraba.puzzle.day16.operators.SumPacket;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HexFormat;
import java.util.List;
import java.util.Optional;

public class PacketDecoder {

    public static final int LITERAL_CHUNK_SIZE = 5;
    public static final int PACKET_SIZE_LENGTH = 15;
    public static final int SUB_PACKETS_LENGTH = 11;
    public static final int TYPE_LENGTH = 3;
    public static final int VERSION_LENGTH = 3;


    public Optional<Packet> decode(String packetString) {
        if (StringUtils.isEmpty(packetString)) {
            return Optional.empty();
        }
        return Optional.of(decodePacket(new PacketData(toBinaryChars(packetString))));
    }

    private Packet decodePacket(PacketData data) {
        int version = getVersion(data);
        int type = getType(data);

        if (type == 4) {
            return decodeLiteralPackage(version, data);
        }
        return decodeOperatorPackage(version, type, data);
    }

    private Packet decodeLiteralPackage(int version, PacketData data) {
        return new LiteralPacket(version, readLiteralValue(data));
    }

    private Packet decodeOperatorPackage(int version, int type, PacketData data) {
        String typeId = data.splitChunk(1);
        OperatorPacket packet = buildOperatorPacket(version, type);
        List<Packet> subPackets = "1".equals(typeId) ? decodeSubPackagesByAmount(data) : decodeSubPackageByLength(data);

        subPackets.forEach(packet::addSubPacket);

        return packet;
    }

    private long readLiteralValue(PacketData data) {
        StringBuilder value = new StringBuilder();
        char prefix;

        do {
            String chunk = data.splitChunk(LITERAL_CHUNK_SIZE);
            value.append(chunk.substring(1));
            prefix = chunk.charAt(0);
        } while (prefix != '0');

        return toDecimalLong(value.toString());
    }

    private List<Packet> decodeSubPackageByLength(PacketData data) {
        int length = toDecimal(data.splitChunk(PACKET_SIZE_LENGTH));
        PacketData subPacketData = new PacketData(data.splitChunk(length));
        List<Packet> subPackets = new ArrayList<>();

        while (subPacketData.hasData()) {
            subPackets.add(decodePacket(subPacketData));
        }
        return subPackets;
    }

    private List<Packet> decodeSubPackagesByAmount(PacketData data) {
        int amount = toDecimal(data.splitChunk(SUB_PACKETS_LENGTH));
        List<Packet> subPackets = new ArrayList<>(amount);

        for (int i = 0; i < amount; i++) {
            subPackets.add(decodePacket(data));
        }
        return subPackets;
    }

    private int getType(PacketData data) {
        return toDecimal(data.splitChunk(TYPE_LENGTH));
    }

    private int getVersion(PacketData data) {
        return toDecimal(data.splitChunk(VERSION_LENGTH));
    }

    private String toBinaryChars(String packetString) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < packetString.length(); i++) {
            result.append(to4bitBinary(packetString.substring(i, i + 1)));
        }
        return result.toString();
    }

    private String to4bitBinary(String hex) {
        return StringUtils.leftPad(Integer.toBinaryString(HexFormat.fromHexDigits(hex)), 4, '0');
    }

    private int toDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

    private long toDecimalLong(String binary) {
        return Long.parseLong(binary, 2);
    }

    private OperatorPacket buildOperatorPacket(int version, int type) {
        return switch (type) {
            case 0 -> new SumPacket(version);
            case 1 -> new ProductPacket(version);
            case 2 -> new MinPacket(version);
            case 3 -> new MaxPacket(version);
            case 5 -> new GreaterThanPacket(version);
            case 6 -> new LessThanPacket(version);
            case 7 -> new EqualToPacket(version);
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }
}

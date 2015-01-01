package im.tox.dht.fetcher;

public class InMemoryNodeFetcher extends StringNodeFetcher {
    private static final String json = "{\"servers\": [{\"ipv6\": null, \"owner\": \"lkwg82\", \"port\": 33445, \"pubkey\": \"2C308B4518862740AD9A121598BCA7713AFB25858B747313A4D073E2F6AC506C\", \"ipv4\": \"144.76.93.230\"}, {\"ipv6\": null, \"owner\": \"lawk1\", \"port\": 33445, \"pubkey\": \"58D2DE4B169502669941E50780C1630FAA48A0B7026D6F4066C320D47AC6401E\", \"ipv4\": \"178.62.150.106\"}, {\"ipv6\": null, \"owner\": \"aitjcize\", \"port\": 33445, \"pubkey\": \"7F9C31FE850E97CEFD4C4591DF93FC757C7C12549DDD55F8EEAECC34FE76C029\", \"ipv4\": \"54.199.139.199\"}, {\"ipv6\": \"2a01:4f8:191:64d6::1\", \"owner\": \"sonOfRa\", \"port\": 33445, \"pubkey\": \"04119E835DF3E78BACF0F84235B300546AF8B936F035185E2A8E9E0A67C8924F\", \"ipv4\": \"144.76.60.215\"}, {\"ipv6\": null, \"owner\": \"Jfreegman\", \"port\": 443, \"pubkey\": \"8CD087E31C67568103E8C2A28653337E90E6B8EDA0D765D57C6B5172B4F1F04C\", \"ipv4\": \"104.219.184.206\"}, {\"ipv6\": \"2607:5600:284::2\", \"owner\": \"Tox RELENG\", \"port\": 33445, \"pubkey\": \"951C88B7E75C867418ACDB5D273821372BB5BD652740BCDF623A4FA293E75D2F\", \"ipv4\": \"192.254.75.102\"}, {\"ipv6\": \"2a03:b0c0:1:d0::178:6001\", \"owner\": \"astonex\", \"port\": 33445, \"pubkey\": \"10B20C49ACBD968D7C80F2E8438F92EA51F189F4E70CFBBB2C2C8C799E97F03E\", \"ipv4\": \"178.62.125.224\"}, {\"ipv6\": null, \"owner\": \"noisykeyboard\", \"port\": 33445, \"pubkey\": \"5918AC3C06955962A75AD7DF4F80A5D7C34F7DB9E1498D2E0495DE35B3FE8A57\", \"ipv4\": \"104.167.101.29\"}, {\"ipv6\": \"2a03:b0c0:2:d0::16:1\", \"owner\": \"Impyy\", \"port\": 33445, \"pubkey\": \"788236D34978D1D5BD822F0A5BEBD2C53C64CC31CD3149350EE27D4D9A2F9B6B\", \"ipv4\": \"178.62.250.138\"}, {\"ipv6\": \"2001:6f8:1c3c:babe::14:1\", \"owner\": \"Manolis\", \"port\": 33445, \"pubkey\": \"461FA3776EF0FA655F1A05477DF1B3B614F7D6B124F7DB1DD4FE3C08B03B640F\", \"ipv4\": \"130.133.110.14\"}, {\"ipv6\": \"2a02:2308::216:3eff:fe82:eaef\", \"owner\": \"SylvieLorxu\", \"port\": 33445, \"pubkey\": \"4B2C19E924972CB9B57732FB172F8A8604DE13EEDA2A6234E348983344B23057\", \"ipv4\": \"178.21.112.187\"}, {\"ipv6\": null, \"owner\": \"nurupo\", \"port\": 33445, \"pubkey\": \"F404ABAA1C99A9D37D61AB54898F56793E1DEF8BD46B1038B9D822E8460FAB67\", \"ipv4\": \"192.210.149.121\"}, {\"ipv6\": \"2a02:29b8:1737::fee1:bad:6483:467d\", \"owner\": \"Nikolai Toryzin\", \"port\": 443, \"pubkey\": \"2A4B50D1D525DA2E669592A20C327B5FAD6C7E5962DC69296F9FEC77C4436E4E\", \"ipv4\": \"31.7.57.236\"}, {\"ipv6\": null, \"owner\": \"Thierry Thomas\", \"port\": 33445, \"pubkey\": \"7A2306BFBA665E5480AE59B31E116BE9C04DCEFE04D9FE25082316FA34B4DA0C\", \"ipv4\": \"78.225.128.39\"}, {\"ipv6\": \"2001:41d0:0052::0507\", \"owner\": \"mousey\", \"port\": 33445, \"pubkey\": \"5EB67C51D3FF5A9D528D242B669036ED2A30F8A60E674C45E7D43010CB2E1331\", \"ipv4\": \"37.187.46.132\"}, {\"ipv6\": \"2001:bc8:3698:101::1\", \"owner\": \"Munrek\", \"port\": 33445, \"pubkey\": \"E398A69646B8CEACA9F0B84F553726C1C49270558C57DF5F3C368F05A7D71354\", \"ipv4\": \"195.154.119.113\"}, {\"ipv6\": \"2604:180:1::3ded:b280\", \"owner\": \"stal\", \"port\": 33445, \"pubkey\": \"A09162D68618E742FFBCA1C2C70385E6679604B2D80EA6E84AD0996A1AC8A074\", \"ipv4\": \"23.226.230.47\"}, {\"ipv6\": null, \"owner\": \"pastly\", \"port\": 33445, \"pubkey\": \"3E1FFDEB667BFF549F619EC6737834762124F50A89C8D0DBF1DDF64A2DD6CD1B\", \"ipv4\": \"192.3.173.88\"}, {\"ipv6\": null, \"owner\": \"aceawan\", \"port\": 33445, \"pubkey\": \"391C96CB67AE893D4782B8E4495EB9D89CF1031F48460C06075AA8CE76D50A21\", \"ipv4\": \"195.154.109.148\"}, {\"ipv6\": null, \"owner\": \"Martin Schr\\u00f6der\", \"port\": 33445, \"pubkey\": \"F5A1A38EFB6BD3C2C8AF8B10D85F0F89E931704D349F1D0720C3C4059AF2440A\", \"ipv4\": \"46.38.239.179\"}, {\"ipv6\": null, \"owner\": \"bunslow\", \"port\": 33445, \"pubkey\": \"93574A3FAB7D612FEA29FD8D67D3DD10DFD07A075A5D62E8AF3DD9F5D0932E11\", \"ipv4\": \"76.191.23.96\"}]}";

    public InMemoryNodeFetcher() {
        super(json);
    }
}

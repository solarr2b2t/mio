package nick;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public final class SettingModes {
    private static final Object MIN, MAX;
    private static final Field _ENUM;

    static {
        try {
            Class<?> k = Class.forName("me.mioclient.m$$KhWP9qaEyk4Hpf2s6QAMxOObFwGNhRe4O85tW7lF7YC66NpK19NKJO2PsEofzYs8I922737IwETboj8jk8TQNWamDuqdBrJoZ");
            Class<?> setting = Class.forName("me.mioclient.m$$0Ye0Mud79axyAy5WakImpp53a1hms7aHNufwVYTk1eW4TU74lRufY6TtGKzLOKeI3yFLaoXRNxRpH24CKcL4Dx18niBYQ1zFy");
            _ENUM = setting.getDeclaredField("m$$5MboGFw38iES2SkGZgh241PovkYJP7N6Fl6LF4X061iBvDQJi0sz3hn72rtSikm4CAODVPkXFxQEHZFNjWln1Jb3XM83lj3Ty");
            _ENUM.setAccessible(true);
            MIN = k.getDeclaredField("m$$1jbHHI9nFSIpA9U8eoz82KFHfdn9Tso5b1RBvx1ALJGxcQm5uvhe9qoNiljL5ML6iJo6XkCSUunyQJ94kbQbw2bWgishoULBf").get(null);
            MAX = k.getDeclaredField("m$$ggqzNTozuGMJhSHrflUeOAPDD2zxMHthcxUeogwst9jD1theXVclvjxs3PIcOd6vuTWNLZjLXCJRSBJWFFS492FDGtEnAI8hU").get(null);
        } catch (Throwable _t) {
            _t.printStackTrace(System.err);
            throw new RuntimeException();
        }
    }

    private static Enum<?> get(long id) {
        if (id == 0x70E9F9120L) { // MIN
            return (Enum<?>) MIN;
        } else if (id == 0x70E9F90D8L) { // MAX
            return (Enum<?>) MAX;
        } else throw new RuntimeException("unknown id: " + Long.toHexString(id));
    }

    private static final Map<String, Long> DATA = new HashMap<>();

    public static void apply(String setting, Object inst) {
        try {
            Long id = DATA.get(setting);
            if (id == null) return;
            Enum<?> e = get(id);
            _ENUM.set(inst, e);
        } catch (Throwable _t) {
            _t.printStackTrace(System.err);
            throw new RuntimeException();
        }
    }

    static {
        DATA.put("me/mioclient/m$$nU5QScyLvqTIYV5SHnKf5YKBPqULp1rPI9mePl2jh0MZCvI6iSm91HLXWESvRnm9eoKmKdkGhU9kV4K7t3FN3y2itm9XMsntd.m$$xmjP7hRYaZDLffqRig1bv4FPCs4ewCRvwvQiAPk7LHvg6xYIkEMzogec12bPX5l6hN4DkP7edu8P9Dnd6q3JZpSZv4D9l4ZkC", 0x70e9f9120L);
        DATA.put("me/mioclient/m$$CiUfele6rHjFIbPEHBsKIPnqbUD3gFk2kqtqxs3PZ0DTn1HoHAqIpAqzW0ppwLTLlbqyINDvym504HOfivcC4BHgsBJeear3P.m$$bTZDAjx7VTBQ6Y1noYCAboU3Vt7q8qZYqMGhRYJVQFQGyed2fwVKDmSZk9WaR7Jk1Z5CTQVnEhgRkXP5NTcWZNPk2DNijFLkj", 0x70e9f9120L);
        DATA.put("me/mioclient/m$$7i0rPjdt3w4ZLbZHr09oI8bX4oZPXNPmZWATRnXFVtNACoiKHMrXMULOFTmBKfKW8c1ny3MRwAraKSM2TWi94COiUYcIsQiAq.m$$FQSOw3zE8LQypkTfLzgyTL6zFAMv9gy5XVEOFF3Qq3IjXxZHxH2o5gLRhkghJj0sZCTWs7G3pPrYka9Tl4tI7bHJA1pfiq8hu", 0x70e9f9120L);
        DATA.put("me/mioclient/m$$D2B2WxYEQBkhgXFAoZ9nScSI4r8uCzm3f7GhmZrsZvofgJAtPB6fpq0F5Xrbls0uZqbB9rrKDerCcM3AlTeUsHTXG6uY9fQNQ.m$$NV4A8XseQfpqCOuF5imQv9XPEmla3QtPzcvq5VK2yk6Z0iCmuzkmJ51C0EzgVmAQvDCx2FCRsBAPmd4OukfixB277BvACbIfg", 0x70e9f9120L);
        DATA.put("me/mioclient/m$$rhpqCJbIuocPTvoBSRWEtbuGIT6nIY2MTAHKE4Ot9lwM7BLBe1atzD47k9ayV2RjidwnBfrOuJDSdR58SdYFHUPl2gAlOEuRs.m$$dmgCSltznBJmepftxf5LwMdcxTgJ7cHctC8EWmpenqhd3UEEiNdCunS3A09lnfcjb5NzGGhgdKLbc1FaRgt9DR2wXh856cDXS", 0x70e9f9120L);
        DATA.put("me/mioclient/m$$gRCBlZT61A5nUg57csqxeqsYCfWd0zCrHZIDjmdQd5FPV9ByNw8kvYu6cQtgfcj1iH5xX91qIUvOzlNIeOzOIxQMCw6cgLiJS.m$$cYe4rvgitylelQSfEJOeJuC3YhsTpsQHuEld1PoUGmNt4DvNpNEI5SKFa98ScxtlqDNOsloFuLMHEqeKPkff8zoUsyzwD7bng", 0x70e9f90d8L);
        DATA.put("me/mioclient/m$$lFc71fclno8eK3Em9M8lmiTAtDyAU67gXqNw2cUKwwM4xbNsZ0AAtkDTCNclFsv0DkUnZl4qAUHbvktUKN93g7iHLe3diGN0W.m$$R67C71jPhksZT5jH8YIHyAdiKXPqzW82Xq1Cm0yGGJDl5xFo8UVlw016lnMerowcBV9tlIwOVk8wzO3EUaWNtJUU9GW1DTq0u", 0x70e9f9120L);
        DATA.put("me/mioclient/m$$KzXKNgyqsQwuEyah31VB0jV5bq5AGHs2RWGWqoEK2Hcg9GRgi8FuaoudOvY6GprALXehdvIwyxwQx4d21XisdNKVEzh4Iu7xY.m$$zOn32qTiNSK2DCIy4TpiHeSSWaBsdtYY7w2lX0dnX0MtlvdnNjhBAjbeO7ZYcjOvtFEriqeUfeWzR3e9t4N6SMCwPBLboffgr", 0x70e9f9120L);
        DATA.put("me/mioclient/m$$GZksVb1Ug6jduNjNIN8iiRKwMMHhBeh5avJSQ1WLEUDCUDeKqbx2DWpCOHwICNaK4LSd6usJGnQ5yOUhX18USMVKr2ztsOLCF.m$$OoVIBDa7KWN2YlAjMYFC76T64QU8hObKfE70hReu41b0pI1tJOGKmqrkO3VJsen0Fmrqow4kHSGJr6uOC4XVU5rbJNWimnW7S", 0x70e9f9120L);
        DATA.put("me/mioclient/m$$8xmEH0Qc6aUwvkjkTKpmC2rYKsn2ZJ1qjPlPpEqzItF4cpNtSgU874JyPqCevNCFK4GVDoOkDKmoMR8trhHkZFdtcV4C360ap.m$$6h1e92154CMhMHRMaztCM81XSrbJYvLiPiJyUuaK7ZIljWMxLfbe7rZnldRLDgq2Pl9R5EQA5nxlfknzSNWNbi9pkKuDyM28A", 0x70e9f9120L);
        DATA.put("me/mioclient/m$$ZC9Q0UOQjXQXRTQFkZnVGbGkDQsIIv4noZdqTSF1A8SsuI10evBsLdiy9woLkEkPtglXG8HBLqxgcoglZ0inLBp5OCV3TQ0k1.m$$kksOPs61gCdlH3zpPqoBz5O2GquN87THEVBwS5uMGaUXNuOq8dDNto1wBc610tYMzaGHMh4UMdW3kOxtSg8xx871JKfVGVIOf", 0x70e9f90d8L);
        DATA.put("me/mioclient/m$$Ifxdx6jchmqvuXJ8Hp61cwTHyBTBmSVL9Ote3aUuR4ZM3qvyxZK07NEw61bBjqF35UF7nzR4zS4oqxpmjjs7HvyukywfQQAK5.m$$NjVJwSMqBnlMHVZskVYC5aIRITVi3oeC52wDrdXgIqQxB0lWuGtIT6Fk5ew4M7vOxUzP7RzzXZS2soBamK4zo97cyivih2Vih", 0x70e9f90d8L);
        DATA.put("me/mioclient/m$$lHOlPcIP5YPas0LPwQZckh3bzB89elu8w4cYsZ7WOETuNNMLPYWejp3dlLBQNm3NBbyOvWkO4DatFTiBJ9HniRxXl2l2Y7Ncs.m$$Ht0gJRds0PX9dOL9RdAfxLB4TSKFcHNgDTWR9TiMb9jpKTg5uSQWnA3oHz5OYRkTDO9QXhcC5FfHoLEe4zOMhzUyxE6JS3AVq", 0x70e9f90d8L);
        DATA.put("me/mioclient/m$$lHOlPcIP5YPas0LPwQZckh3bzB89elu8w4cYsZ7WOETuNNMLPYWejp3dlLBQNm3NBbyOvWkO4DatFTiBJ9HniRxXl2l2Y7Ncs.m$$z7E8Ed4conEkClwikeRAFOzYI6D6spQZHFo04LJhHKPBxiSIh5kPjcADwdxpbQFPezlBWuh9gnqZUSurdyV0qhhE4FHHkxDQS", 0x70e9f9120L);
        DATA.put("me/mioclient/m$$cAiaw0siRkKVw6DwkQK3Br6TGkOXciGdUl6ETQegFCgjUYdED5ur1IpSXX1yUubBpLyf9s7uvN8dzl9Pa3f2KgmxchgC93Lds.m$$NawlPuy3YutCGUbCbKJSiccA8RkVUWWw8rXpO1qabzouDKsqX3ORXM1QANnsAwZNBr2xwPW2vO5UGGi22KuUl8MIDtVtsVuze", 0x70e9f90d8L);
        DATA.put("me/mioclient/m$$SoYN81EAm6Khc44ciCopqKXAzrTnK1KghvyrrD9swUcgI7kvmzVJrX1pEScPYgfrEfA6uhxoC9LUXHw2X1wV1dScUvISd9Ku2.m$$GFVgVQoJiWZGNiF3q3AVvGcsrrvzUhohTt5dnKXLQ1F7jPSCYhWuf8QUPbRiTG0fNh8vzBnh8NGm082tSjrfTfTL0KNOnPeW7", 0x70e9f90d8L);
        DATA.put("me/mioclient/m$$SoYN81EAm6Khc44ciCopqKXAzrTnK1KghvyrrD9swUcgI7kvmzVJrX1pEScPYgfrEfA6uhxoC9LUXHw2X1wV1dScUvISd9Ku2.m$$UFPB1uxzTUgcCduzfgUWzQPoVsGRKSms7NqJWTJyAxMlv5k145Hu5BO4NZDPPkxt7iDCFToDsxLvkwLCnUmdCC9cHaOWVyX5X", 0x70e9f90d8L);
        DATA.put("me/mioclient/m$$pIqms7HpWG6MpZJvCstw1lehCq7S8Fm5oHZxE1oj1sFUDZi80HHtQObj1L7F6d3iDfykD9eSP1yUr63GXhbwfJvucr182sVDB.m$$l7rfdlWZlAmA8n1v2PEA74hqCGxTHXsTIOZXTedyaZTztn6ZwtsfA6cVTtudPA1ZE6aXmr0KlwCFVJ2fYS4uvxFicSHN901fJ", 0x70e9f9120L);
        DATA.put("me/mioclient/m$$pIqms7HpWG6MpZJvCstw1lehCq7S8Fm5oHZxE1oj1sFUDZi80HHtQObj1L7F6d3iDfykD9eSP1yUr63GXhbwfJvucr182sVDB.m$$JZOICfFWEK5q38oez72yPuPFnjubmG7RPdSpAkSuIEECqzMgOvSKxX39Jraqi53JcveTQCK3jlcJarr00sXP287CPisGN2eNj", 0x70e9f9120L);
        DATA.put("me/mioclient/m$$d59dM0hZZMTHApRHIygEcWI9EzJARSqFIfe1ABW47KspOjZ3rYgXbZpYlmFNhJxrIhWjY5yM5BgPWdBRp7U1bsMSBeLvBilXN.m$$dK4A779vbZ1i7qwf4psrPICZOnqyWUxEpecxXZgSpXJ9g6gqNOBqnf0AGukYXhTrCN4IfK6r1BvdyXT2pL52PmRocuefA1TMN", 0x70e9f9120L);
        DATA.put("me/mioclient/m$$SP7VZoXgoZVvdfknYS03fWKLkndFA7xiBA757AtUtyw6FzUdoRGvx8RXQRP5y7r5eiZtMNQE722a9IHmdc7pt9NCi8kXYnNbc.m$$GKxZQI6AROz6KpUXceHm8Eyfif2fqXkLx6BgI4YhMVNJW3OG6YNFN3uGOglgOSkuoA9bJKiZorU5sKBGMIbFnEIBFABkFaV64", 0x70e9f9120L);
    }
}
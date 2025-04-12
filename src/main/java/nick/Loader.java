package nick;

import net.fabricmc.api.ModInitializer;

import java.lang.invoke.MethodHandles;

public final class Loader implements ModInitializer {
    @Override
    public void onInitialize() {
        try {
            MethodHandles.lookup().ensureInitialized(Class.forName("me.mioclient.m$$4bYansx8qyCgfT2CXLJ2ofFTegcTeSQNQmfVWPDznXkBQZZUajn7VVZufassgVXx3cSzarSvG0nZRdXDrqCHwFBlwqb90tTgh"));
        } catch (Throwable _t) {
            _t.printStackTrace(System.err);
        }
    }

    // ZMPWTN41Nyj57ZpSCcRp9FqsVI36hwo4cYHyLzKthaWwvxxQCnOBvKmUNFqBkGRvW9qKy3T7R6G9OkGnVJyhLkTbmnqrnKcf5IIV
    public static int getInt(long key) {
        return Ints.getInt(key);
    }

    // 7IgZv9bBL5GpyGTf0kFTQpZX9VWJwgZFTFXlfKJ1x9FHDv9zDA7Ntr6wDp1wDNWSCHg8DYCpducbijJx2MEnobhlOb9ksiHrPH7r
    public static String getString(int key) {
        return Strings.getString(key);
    }

    // XcoQ21IHePK35f5KHSE5Qdf2ZviypIEUP3uY90diNIsxLToAlyYWCgDd7b5GBi4Rhb69FqZaWlmZxwtMwgglZv0DrkUspHkW5fH4
    public static Object getConstant(int key) {
        return switch (key) {
            case 8242560 -> 45;
            case 6040919 -> 90;
            case 6786675 -> 360;
            case 5150641 -> 3.141592653589793D;
            case 5148802 -> 0.5D;
            case 7797789 -> 0.25D;
            case 5314762 -> 0.017453292519943295F;
            case 4647205 -> 57.29577951308232F;
            default -> throw new RuntimeException(String.valueOf(key));
        };
    }

    // NQgBxPvHu2CtjBoU3wrUzMnWZ6Y7u8Q0YGyrVJVXwSeNXqEilhrtes8ckkWQRQCoJkjuxKJBqHTRBTjAhNARHYA1bb1wTomJsDFQ
    public static void setup() {
        try {
            final Class<?> k = Class.forName("me.mioclient.m$$L9uXGiAoIDTxbqRILEtTUPx9uQs3CDmAonFZIVQXOUEifrHjdjelrib23kToHtVVx563T8QQwhiCRsYwrfPybFh0Smxm6uHvr");
            k.getDeclaredField("m$$i0IzHBAlPXNZIGftaR9YScllb9clMMe74sycvIi7FJZi0IvQF35ezW1sDpjjBuTjYYxe3dScJaZhf10i6x3ktAqL48rE1589f").set(null, 5);
            k.getDeclaredField("m$$2MpeKmFHJVaviAB1F0K6e34ToZPRu0cl0RztqJ2QwRdKuWIqPTtGs78Lf100HGDL2gO3a5bsW7eeKEloC76MgmCT6xiQrRc6H").set(null, "");
            k.getDeclaredField("m$$9HeBnT4MwaWiXhu5Hpu69GJ9RzfL4slkk5jtAfcIgmjyJI0yqPGpXDp97kBKRmEjwCsYDqt6hA9qeVn1gSHK2nIttgqUhBURU").set(null, "");
            k.getDeclaredField("m$$IHBX4hCuwZ2KeSVmCceYZ7356aerzs5mhAScCaieQBzYEwMugPsoBs3M4K5850Z9vEXVbyjepncfSj7kaDts2VogYfZg0Cd9g").set(null, 0L);
            k.getDeclaredField("m$$8NSuADd2QA8NNmAt0dMgsB5XHxERhiOaF3LvcTk9mp8bqWELTRt58yJutQ39XHgvII9SPlcjrs6mH3fANJzTjUgm4c1a5DUAL").set(null, 0L);
        } catch (Throwable _t) {
            _t.printStackTrace(System.err);
            throw new RuntimeException();
        }
    }

    // iF76bRYZlpLqy2DEIbPLyXlrT5vP8xV9S7sDRHyqEPe9A6Seo3uijfG7nxvvaCeUSPO9Tcv0mfW9Kq6pbeNKpmAwlwEAkJPOUGzK
    public static void modules(Object manager) {
        Modules.initialize(manager);
        Modules.extra(manager);
    }

    // uLyY171HjwpL4FDmQOeWDe6vcl41P82VuQ1kYPJGSzZOqObK7pAExl1qngN91GmHvjmwkb8yGoBehITnO3CE1yCaLs46nHn1pIcB
    public static void commands(Object manager) {
        Commands.initialize(manager);
    }

    // hSSzy3DhSr5ruAzQYTgccnp8SSwS8rhRrj8vW9ef8XEjt34kA99GHviEIKzVQp7BTBtl75e0EWBZsUJTWtZEs6p7We9NOmg1wHwk
    public static void settings(Object module) {
        Settings.initialize(module);
    }
}
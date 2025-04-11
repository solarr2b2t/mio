package nick;

import net.fabricmc.api.ModInitializer;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public final class Loader implements ModInitializer {
    @Override
    public void onInitialize() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe usf = (Unsafe) f.get(null);
            usf.ensureClassInitialized(Class.forName("me.mioclient.m$$4bYansx8qyCgfT2CXLJ2ofFTegcTeSQNQmfVWPDznXkBQZZUajn7VVZufassgVXx3cSzarSvG0nZRdXDrqCHwFBlwqb90tTgh"));
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
            final Object[] data = {5, "", "", 0L, 0L};
            int c = 0;

            for (Field field : k.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) continue;
                if (!field.getType().isAssignableFrom(data[c].getClass())) throw new RuntimeException();
                field.setAccessible(true);
                field.set(null, data[c]);
                c++;
            }
        } catch (Throwable _t) {
            _t.printStackTrace(System.err);
        }
    }

    // iF76bRYZlpLqy2DEIbPLyXlrT5vP8xV9S7sDRHyqEPe9A6Seo3uijfG7nxvvaCeUSPO9Tcv0mfW9Kq6pbeNKpmAwlwEAkJPOUGzK
    public static void modules(Object manager) {
        Modules.initialize(manager);
    }

    // uLyY171HjwpL4FDmQOeWDe6vcl41P82VuQ1kYPJGSzZOqObK7pAExl1qngN91GmHvjmwkb8yGoBehITnO3CE1yCaLs46nHn1pIcB
    public static void commands(Object manager) {
        Commands.initialize(manager);
    }
}
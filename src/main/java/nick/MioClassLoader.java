package nick;

import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.SecureClassLoader;

public final class MioClassLoader extends SecureClassLoader {
    private final ClassLoader loader;

    public MioClassLoader(final ClassLoader l1, final ClassLoader l2) {
        super(l1);
        this.loader = l2;
    }

    @Override
    public Class<?> loadClass(final String klass) throws ClassNotFoundException {
        return this.loader.loadClass(klass);
    }

    @Override
    protected Class<?> findClass(final String string) throws ClassNotFoundException {
        return super.findClass(string);
    }

    @Override
    public URL getResource(final String string) {
        return this.loader.getResource(string);
    }

    @Override
    public InputStream getResourceAsStream(final String string) {
        final InputStream stream = this.loader.getResourceAsStream(string);
        if (stream != null) return stream;
        InputStream r = MioClassLoader.class.getClassLoader().getResourceAsStream(String.format("mio/%d.bin", Hash.hash(string.getBytes(StandardCharsets.UTF_8))));
        if (r != null) return r;
        return this.loader.getResourceAsStream(String.format("mio/%d.bin", Hash.hash(string.getBytes(StandardCharsets.UTF_8))));
    }
}
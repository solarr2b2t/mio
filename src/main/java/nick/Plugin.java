package nick;

import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

import java.lang.reflect.Field;

public final class Plugin implements PreLaunchEntrypoint {
    static {
        try {
            final ClassLoader loader = Plugin.class.getClassLoader();
            final Field f1 = loader.getClass().getDeclaredField("delegate");
            f1.setAccessible(true);
            final Object delegate = f1.get(loader);
            final Field f2 = loader.getClass().getDeclaredField("originalLoader");
            f2.setAccessible(true);
            final ClassLoader original = (ClassLoader) f2.get(loader);
            final Field f3 = delegate.getClass().getDeclaredField("parentClassLoader");
            f3.setAccessible(true);
            final ClassLoader parent = (ClassLoader) f3.get(delegate);
            final MioClassLoader mio = new MioClassLoader(parent, original);
            f2.set(loader, mio);
            f3.set(delegate, mio);
        } catch (Throwable _t) {
            _t.printStackTrace(System.err);
        }
    }

    @Override
    public void onPreLaunch() {}
}
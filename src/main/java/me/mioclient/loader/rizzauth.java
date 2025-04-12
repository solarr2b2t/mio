package me.mioclient.loader;

@SuppressWarnings("unused")
public final class rizzauth {
    /*public static class Compatability {
        private static boolean exists = new File(System.getProperty("user.home") + File.separator + "Mio" + File.separator + "mod_warnings_disabled").exists();

        public static void verify(final String mod) throws Throwable {
            Globals.warn("Mod '%s' is incompatible with Mio".formatted(mod));
            if (exists) return;
            final JFrame frame = new JFrame();
            frame.setAlwaysOnTop(true);
            JCheckBox checkbox = new JCheckBox("Do not show this again");
            final String error = "Mod '%s' is incompatible with Mio. You may continue but any compatibility related reports from you will be ignored.".formatted(mod);
            final Object[] arr = new Object[]{error, checkbox};
            JOptionPane.showMessageDialog(frame, arr, "turboloader", JOptionPane.INFORMATION_MESSAGE);
            if (!checkbox.isSelected()) return;
            exists = true;
            final File file = new File(System.getProperty("user.home") + File.separator + "Mio" + File.separator + "mod_warnings_disabled");
            final FileOutputStream stream = new FileOutputStream(file);
            stream.write("Delete this file to turn mod warnings back on".getBytes(StandardCharsets.UTF_8));
            stream.close();
            Globals.warn("Disabled mod warnings. You can enable them back on by deleting file " + file.getAbsolutePath());
        }
    }

    public static boolean check() throws Throwable {
        final File file = Jar.getCurrentPath();
        final FileInputStream stream = new FileInputStream(file);
        final byte[] data = stream.readAllBytes();
        stream.close();
        final CRC32 crc = new CRC32();
        crc.update(data);
        final String string = Long.toHexString(crc.getValue()).toUpperCase();
        final HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://mioclient.me/api/check?w=" + string + "&v=" + FabricLoaderImpl.INSTANCE.getGameProvider().getRawGameVersion())).GET().header("User-Agent", "MioClient/2.0").build();
        final HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        int n = response.statusCode();
        if (n != 200) throw new RuntimeException("Invalid request response code (%d)".formatted(n));
        final JsonObject json = new Gson().fromJson(response.body(), JsonObject.class);
        if (!json.has("mods")) throw new NullPointerException("No mods field");
        final JsonObject mods = json.getAsJsonObject("mods");
        if (!mods.has("required")) throw new NullPointerException("No required field");
        if (!mods.has("incompatible")) throw new NullPointerException("No incompatible field");
        final JsonArray required = mods.getAsJsonArray("required");
        final JsonArray incompatible = mods.getAsJsonArray("incompatible");

        for (final JsonElement element : required) {
            if (!element.isJsonObject()) throw new RuntimeException("Required field is not an object");
            final JsonObject obj = element.getAsJsonObject();
            if (!obj.has("internal")) throw new RuntimeException("Required object doesn't have a required property: internal");
            if (!obj.has("name")) throw new RuntimeException("Required object doesn't have a required property: name");
            final String internal = obj.get("internal").getAsString();
            final String name = obj.get("name").getAsString();
            if (FabricLoaderImpl.INSTANCE.isModLoaded(internal)) continue;
            throw new InvalidResponseException("Mod '%s' is required for Mio to work.".formatted(name));
        }

        for (final JsonElement element : incompatible) {
            if (!element.isJsonObject()) throw new RuntimeException("Incompatible field is not an object");
            final JsonObject obj = element.getAsJsonObject();
            if (!obj.has("internal")) throw new RuntimeException("Incompatible object doesn't have a required property: internal");
            if (!obj.has("name")) throw new RuntimeException("Incompatible object doesn't have a required property: name");
            final String internal = obj.get("internal").getAsString();
            final String name = obj.get("name").getAsString();
            if (!FabricLoaderImpl.INSTANCE.isModLoaded(internal)) continue;
            Compatability.verify(name);
        }

        return true;
    }

    public static class InvalidResponseException extends RuntimeException {
        private final String msg;

        public InvalidResponseException(final String msg) {
            this.msg = msg;
        }

        @Override
        public String getMessage() {
            return this.msg;
        }
    }

    public static class Jar {
        public static File getCurrentPath() throws URISyntaxException {
            return new File(Jar.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        }
    }

    public static class ClassUtil {
        private static long hash(byte[] data, int n) {
            return (long)data[n] & 0xFFL | ((long)data[n + 1] & 0xFFL) << 8 | ((long)data[n + 2] & 0xFFL) << 16 | ((long)data[n + 3] & 0xFFL) << 24 | ((long)data[n + 4] & 0xFFL) << 32 | ((long)data[n + 5] & 0xFFL) << 40 | ((long)data[n + 6] & 0xFFL) << 48 | ((long)data[n + 7] & 0xFFL) << 56;
        }

        public static long hash(final byte[] data, int n, int n2) {
            int n3;
            long l = (long)n2 & 0xFFFFFFFFL ^ (long)n * -4132994306676758123L;
            int n4 = n >> 3;
            for (n3 = 0; n3 < n4; ++n3) {
                int n5 = n3 << 3;
                long l2 = ClassUtil.hash(data, n5);
                l2 *= -4132994306676758123L;
                l2 ^= l2 >>> 47;
                l ^= l2 * -4132994306676758123L;
                l *= -4132994306676758123L;
            }
            n3 = n4 << 3;
            switch (n - n3) {
                case 7: {
                    l ^= ((long)data[n3 + 6] & 0xFFL) << 48;
                }
                case 6: {
                    l ^= ((long)data[n3 + 5] & 0xFFL) << 40;
                }
                case 5: {
                    l ^= ((long)data[n3 + 4] & 0xFFL) << 32;
                }
                case 4: {
                    l ^= ((long)data[n3 + 3] & 0xFFL) << 24;
                }
                case 3: {
                    l ^= ((long)data[n3 + 2] & 0xFFL) << 16;
                }
                case 2: {
                    l ^= ((long)data[n3 + 1] & 0xFFL) << 8;
                }
                case 1: {
                    l ^= (long)data[n3] & 0xFFL;
                    l *= -4132994306676758123L;
                }
            }
            l ^= l >>> 47;
            l *= -4132994306676758123L;
            l ^= l >>> 47;
            return l;
        }

        public static long hash(byte[] data) {
            return ClassUtil.hash(data, data.length, -512093083);
        }
    }

    public static class AuthToken {
        public static boolean exists() throws IOException {
            final File file = new File(System.getProperty("user.home") + File.separator + "Mio" + File.separator + ".authtoken");
            final FileInputStream stream = new FileInputStream(file);

            if (!file.exists()) {
                stream.close();
                return false;
            }

            stream.readAllBytes();
            stream.close();

            return true;
        }
    }

    public static class EntryPoint implements ClientModInitializer, ModInitializer {
        public void onInitialize() {
            Native.a();
        }

        public void onInitializeClient() {
            Native.b();
        }
    }

    public static class Native {
        public static native void a();

        public static native void b();

        public static native Class<?> c(String klass, byte[] data, Object loader);

        public static native byte[] d(long val);

        public static native byte[] e(long val);

        public static native Class<?> f(String klass, byte[] data, Object loader);
    }

    public static class Mio {
        public static void start() throws Throwable {
            final String os = System.getProperty("os.name");
            if (!os.toLowerCase().contains("win")) {
                String error_msg = "Mio only works on Windows (you're running %s). Please contact us at https://mioclient.me/support".formatted(os);
                Globals.warn(error_msg);
                Mio.error(error_msg);
                Mio.exit();
                return;
            }

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            final String fabric_version = Mio.getFabricVersion();
            if (fabric_version != null) {
                Mio.error("Fabric version %s is currently not supported.\nPlease downgrade Fabric to version 0.15.11 or below.".formatted(fabric_version));
                Mio.exit();
                return;
            }

            if (!AuthToken.exists()) {
                Mio.error("No auth token found, please open the installer and log in.");
                Mio.exit();
                return;
            }

            final File file = new File("mio-fabric");

            if (!(file.exists() && file.isDirectory() || file.mkdir()))
                throw new RuntimeException("Failed to create the mio-fabric directory");

            SocketConnection.start();

            final int jdk_version = rizzauth.getJdkVersion();
            if (jdk_version != 17) {
                Mio.error("Only Java 17 is supported (you're running Java %d).".formatted(jdk_version));
                Mio.exit();
                return;
            }

            final String vendor = System.getProperty("java.vm.vendor").toLowerCase();
            if (vendor.contains("eclipse adoptium")) {
                Mio.error("Eclipse Adoptium is not supported, please switch to a different Java.");
                Mio.exit();
                return;
            }

            final String vm = System.getProperty("java.vendor.version");
            if (vm != null && vm.toLowerCase().contains("graalvm")) {
                Mio.error("GraalVM is not supported, please switch to a different Java.");
                Mio.exit();
                return;
            }

            final String launcher = LauncherUtil.getNonSupported();
            if (launcher != null) {
                Mio.error("%s is not a supported launcher.\n\nIf you need a cracked launcher, you can try these alternatives:\n%s\n%s\n%s".formatted(launcher, "1. Legacy Launcher (https://llaun.ch/)", "2. Prism Launcher (cracked) (https://tinyurl.com/prismdownload)", "3. TLauncher (https://tlauncher.org/)"));
                Mio.exit();
                return;
            }

            Mio.resetMixins();
            System.load(new File("mio-fabric" + File.separator + "turbonative.dll").getAbsolutePath());
        }

        private static void exit() {
            Runtime.getRuntime().halt(0);
            throw new RuntimeException();
        }

        public static void error(String string) {
            final JFrame frame = new JFrame();
            frame.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(frame, string, "turboloader", JOptionPane.ERROR_MESSAGE);
        }

        public static void resetMixins() throws Throwable {
            final ClassLoader loader = Plugin.class.getClassLoader();
            final Field f1 = loader.getClass().getDeclaredField("delegate");
            f1.setAccessible(true);
            final Object delegate = f1.get(loader);
            final Field f2 = delegate.getClass().getDeclaredField("mixinTransformer");
            f2.setAccessible(true);
            final Object transformer = f2.get(delegate);
            final Class<?> clazz = transformer.getClass();
            if (!clazz.getName().contains("spongepowered")) return;
            final Field f3 = clazz.getDeclaredField("processor");
            f3.setAccessible(true);
            final Object processor = f3.get(transformer);
            final Field f4 = processor.getClass().getDeclaredField("transformedCount");
            f4.setAccessible(true);
            f4.setInt(processor, 0);
        }

        private static String getFabricVersion() {
            final Optional<ModContainer> optional = FabricLoaderImpl.INSTANCE.getModContainer("fabricloader");
            if (optional.isEmpty()) return null;
            String string = optional.get().getMetadata().getVersion().getFriendlyString();
            if (string.startsWith("0.16")) return string;
            return null;
        }
    }

    public static class MioClassLoader extends SecureClassLoader {
        private final ClassLoader loader;
        private final Map<String, Class<?>> cm1 = new HashMap<>();
        private final Map<Long, byte[]> cm2 = new HashMap<>();
        private final Map<Long, byte[]> rm = new HashMap<>();
        private final Map<Long, Class<?>> cm3 = new HashMap<>();

        public MioClassLoader(final ClassLoader loader, final ClassLoader loader2) {
            super(loader);
            this.loader = loader2;
        }

        public Class<?> loadClass(final String klass) throws ClassNotFoundException {
            if (this.cm1.containsKey(klass))
                return this.cm1.get(klass);

            long l = ClassUtil.hash(klass.getBytes(StandardCharsets.UTF_8));

            if (this.cm2.containsKey(l)) {
                synchronized (super.getClassLoadingLock(klass)) {
                    final Class<?> clazz = Native.c(klass.replace('.', '/'), (byte[])this.cm2.get(l), Knot.getLauncher().getTargetClassLoader());
                    this.cm1.put(klass, clazz);
                    return clazz;
                }
            }

            if (this.cm3.containsKey(l)) {
                synchronized (super.getClassLoadingLock(klass)) {
                    final Class<?> clazz = Native.f(klass.replace('.', '/'), (byte[])Native.e(l), Knot.getLauncher().getTargetClassLoader());
                    this.cm1.put(klass, clazz);
                    return clazz;
                }
            }

            return this.loader.loadClass(klass);
        }

        protected Class<?> findClass(final String string) throws ClassNotFoundException {
            if (this.cm1.containsKey(string)) return this.cm1.get(string);
            return super.findClass(string);
        }

        @Override
        public URL getResource(final String string) {
            final URL url = this.loader.getResource(string);
            if (url == null) throw new RuntimeException();
            return url;
        }

        @Override
        public InputStream getResourceAsStream(final String string) {
            final InputStream stream = this.loader.getResourceAsStream(string);

            if (stream != null) return stream;

            long l = ClassUtil.hash(string.getBytes(StandardCharsets.UTF_8));

            if (this.rm.containsKey(l))
                return new MioInputStream(Native.d(l));

            return null;
        }
    }

    public static class MioStreamHandler extends URLStreamHandler {
        private final byte[] data;

        public MioStreamHandler(final byte[] data) {
            this.data = data;
        }

        @Override
        protected URLConnection openConnection(final URL url) {
            return new MioURLConnection(url, this.data);
        }
    }

    public static class MioURLConnection extends URLConnection {
        private final byte[] data;

        public MioURLConnection(final URL url, final byte[] data) {
            super(url);
            this.data = data;
        }

        @Override public void connect() {}

        @Override
        public InputStream getInputStream() {
            return new MioInputStream(this.data);
        }
    }

    public static class Plugin implements PreLaunchEntrypoint {
        public void onPreLaunch() {
            try {
                Mio.start();
            } catch (final Throwable _t) { Globals.warn(_t.getMessage()); }
        }
    }

    public static class SocketConnection {
        public static void start() throws Throwable {
            final Socket socket = new Socket("auth.mioclient.me", 25598);
            final String checksum = SocketConnection.checksum();
            final String nchecksum = SocketConnection.nativeChecksum();
            socket.setSoTimeout(7000);
            SocketConnection.verify_packet(socket);
            DataInputStream istream = new DataInputStream(socket.getInputStream());
            DataOutputStream ostream = new DataOutputStream(socket.getOutputStream());
            ostream.writeUTF(FabricLoaderImpl.INSTANCE.getGameProvider().getRawGameVersion());
            ostream.writeUTF(checksum);
            ostream.writeUTF(nchecksum);
            ostream.flush();
            int response = istream.readInt();
            if (response != -4004 && response != -257 && response != -9 && response != -500 && response != 5000022) throw new InvalidResponseException("Invalid server response (%d). Please try again or contact support: https://mioclient.me/support".formatted(response));

            if (response == -9) {
                Globals.printMessage("Updating the loader, please wait...");
                int size = istream.readInt();
                if (size < 100 || size > 0x3200000) throw new InvalidResponseException("Invalid loader jar size (%d). Please try again or contact support: https://mioclient.me/support".formatted(size));
                final byte[] data = new byte[size];
                istream.readFully(data);
                FileOutputStream fostream = new FileOutputStream(Jar.getCurrentPath());
                fostream.write(data);
                fostream.close();
                throw new RuntimeException();
            }

            if (response == -500 || response == 5000022) {
                byte[] data;
                int n4;
                if (response == -500) {
                    n4 = istream.readInt();
                    if (n4 < 100 || n4 > 0x3200000) throw new InvalidResponseException("Invalid packet/2 size (%d). Please try again or contact support: https://mioclient.me/support".formatted(n4));
                    data = new byte[n4];
                    istream.readFully(data);
                    final FileOutputStream fostream = new FileOutputStream("mio-fabric" + File.separator + "turbonative.dll");
                    fostream.write(data);
                    fostream.close();
                }
                if ((n4 = istream.readInt()) <= 0 || n4 > 100000) throw new InvalidResponseException("Invalid validation response size (%d). Please try again or contact support: https://mioclient.me/support".formatted(n4));
                data = new byte[n4];
                istream.readFully(data);
                final JsonObject json = new Gson().fromJson(new String(data, StandardCharsets.UTF_8), JsonObject.class);
                if (!json.has("mods")) throw new NullPointerException("No mods field");
                final JsonObject mods = json.getAsJsonObject("mods");
                if (!mods.has("required")) throw new NullPointerException("No required field");
                if (!mods.has("incompatible")) throw new NullPointerException("No incompatible field");
                final JsonArray required = mods.getAsJsonArray("required");
                final JsonArray incompatible = mods.getAsJsonArray("incompatible");

                for (final JsonElement element : required) {
                    if (!element.isJsonObject()) throw new RuntimeException("Required field is not an object");
                    final JsonObject obj = element.getAsJsonObject();
                    if (!obj.has("internal")) throw new RuntimeException("Required object doesn't have a required property: internal");
                    if (!obj.has("name")) throw new RuntimeException("Required object doesn't have a required property: name");
                    final String internal = obj.get("internal").getAsString();
                    final String name = obj.get("name").getAsString();
                    if (FabricLoaderImpl.INSTANCE.isModLoaded(internal)) continue;
                    throw new InvalidResponseException("Mod '%s' is required for Mio to work.".formatted(name));
                }

                for (final JsonElement element : incompatible) {
                    if (!element.isJsonObject()) throw new RuntimeException("Incompatible field is not an object");
                    final JsonObject obj = element.getAsJsonObject();
                    if (!obj.has("internal")) throw new RuntimeException("Incompatible object doesn't have a required property: internal");
                    if (!obj.has("name")) throw new RuntimeException("Incompatible object doesn't have a required property: name");
                    final String internal = obj.get("internal").getAsString();
                    final String name = obj.get("name").getAsString();
                    if (!FabricLoaderImpl.INSTANCE.isModLoaded(internal)) continue;
                    Compatability.verify(name);
                }
            }

            socket.close();
        }

        private static String nativeChecksum() throws Throwable {
            final File file = new File("mio-fabric" + File.separator + "turbonative.dll");
            if (!file.exists()) return "0092CDEF";
            final FileInputStream stream = new FileInputStream(file);
            final byte[] data = stream.readAllBytes();
            stream.close();
            final CRC32 crc = new CRC32();
            crc.update(data);
            return Long.toHexString(crc.getValue()).toUpperCase();
        }

        private static String checksum() throws Throwable {
            final File file = Jar.getCurrentPath();
            final FileInputStream stream = new FileInputStream(file);
            final byte[] data = stream.readAllBytes();
            stream.close();
            final CRC32 crc = new CRC32();
            crc.update(data);
            return Long.toHexString(crc.getValue()).toUpperCase();
        }

        private static void verify_packet(final Socket socket) throws Throwable {
            final DataInputStream stream = new DataInputStream(socket.getInputStream());
            int n = 0;
            while (n < 15) {
                int size = stream.readInt();
                if (size < 10 || size > 100) throw new InvalidResponseException("Invalid packet size (%d). Check your internet connection.");
                final byte[] data = new byte[size];
                stream.readFully(data);
                ++n;
            }
        }
    }

    public static class MioInputStream extends InputStream {
        protected byte[] buf;
        protected int pos;
        protected int mark = 0;
        protected int count;

        public MioInputStream(final byte[] data) {
            this.buf = data;
            this.pos = 0;
            this.count = data.length;
        }

        public MioInputStream(final byte[] data, int pos, int len) {
            this.buf = data;
            this.pos = pos;
            this.count = Math.min(pos + len, data.length);
            this.mark = pos;
        }

        @Override
        public synchronized int read() {
            return this.pos < this.count ? this.buf[this.pos++] & 0xFF : -1;
        }

        @Override
        public synchronized int read(final byte[] data, int off, int len) {
            Objects.checkFromIndexSize(off, len, data.length);

            if (pos >= count) return -1;

            int available = count - pos;
            if (len > available) len = available;
            if (len <= 0) return 0;
            System.arraycopy(buf, pos, data, off, len);
            pos += len;
            return len;
        }

        @Override
        public synchronized byte[] readAllBytes() {
            final byte[] data = Arrays.copyOfRange(this.buf, this.pos, this.count);
            this.pos = this.count;
            return data;
        }

        @Override
        public int readNBytes(final byte[] b, int off, int len) {
            int n = read(b, off, len);
            return n == -1 ? 0 : n;
        }

        @Override
        public synchronized long transferTo(final OutputStream stream) throws IOException {
            int len = count - pos;
            stream.write(buf, pos, len);
            pos = count;
            return len;
        }

        @Override
        public synchronized long skip(long n) {
            long available = count - pos;
            if (n < available) available = n < 0 ? 0 : n;
            pos += (int) available;
            return available;
        }

        @Override
        public synchronized int available() {
            return this.count - this.pos;
        }

        @Override
        public boolean markSupported() {
            return true;
        }

        @Override
        public void mark(int n) {
            this.mark = this.pos;
        }

        @Override
        public synchronized void reset() {
            this.pos = this.mark;
        }

        @Override public void close() {}
    }

    public static class LauncherUtil {
        public static String getNonSupported() throws URISyntaxException {
            final String string = Jar.getCurrentPath().getAbsolutePath();

            if (string.contains("Crystal Launcher") || string.contains("Crystal-Launcher"))
                return "Crystal Launcher";

            final List<String> args = ManagementFactory.getRuntimeMXBean().getInputArguments();

            for (final String arg : args) {
                final String lowercase = arg.toLowerCase(Locale.ROOT);
                if (!lowercase.contains("javaagent") || !lowercase.contains("sklauncher")) continue;
                return "SKlauncher";
            }

            return null;
        }
    }

    public static void update() throws Throwable {
        final  File file = Jar.getCurrentPath();
        final URL url = new URL("https://mioclient.me/files/mioloader.jar");
        final FileOutputStream ostream = new FileOutputStream(file);
        final BufferedInputStream istream = new BufferedInputStream(url.openStream());
        byte[] buf = new byte[1483769];
        int n;
        while (true) {
            n = istream.read(buf, 0, 8192);
            if (n == -1) break;
            ostream.write(buf, 0, n);
        }
        ostream.close();
        istream.close();
    }

    public static int getJdkVersion() {
        String string = System.getProperty("java.version");
        if (string.startsWith("1.8")) string = string.substring(2, 3);
        else {
            int n = string.indexOf(".");
            if (n != -1) string = string.substring(0, n);
        }
        return Integer.parseInt(string);
    }*/
}
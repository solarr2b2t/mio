package nick;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

public final class Commands {
    private static final List<String> COMMANDS = List.of(
            "me/mioclient/m$$phnaVQmM3WuGZPdNg1Yy3CXWRGzGoQ5krjXRbKGKIJaU3sAYtvKQ5IoUiHifyW8c2QzeFoVEv3kPIz6nQV1rAwmEaw85bNZgp",
            "me/mioclient/m$$BUgj63ReRWIKjgQG0xSBahAdrekfOLC80ybQyYAj0U8f85yGYXHsyVBXAsPc96sAfSNt1SgyTFBoVEXpLBZdWzmnObu4wYd6q",
            "me/mioclient/m$$5BSkW7NXxYeK9v2neAwWE734aDB9ET4rUVl15Ud2ztwiBykrBeSLSG7TwqE5zpXL33YTloUyI2vLsO7eO1cUvjhBDrtyEZBt1",
            "me/mioclient/m$$a3rPFQarNQPPic1NwZOAKLZLYfVmj0siaEQ9NmY1CrSuopftYbT5zsNHCaX6fk59nJZCvd8WwvrlUVdk6Qf49ulRypoDtkHJr",
            "me/mioclient/m$$a36izZOIeeGOLf2FI3uKVA3AiQjKiE38FdMMzlFL4CNw1A3hOa91XKsLXqrjHsvZeFoILk8MYO21lMucxraLzTIzzpWHaxRAK",
            "me/mioclient/m$$LMoURoHYt2qpquXVFhysy2KZMgJLsGn5Y17bSfLALNkSryiS3TguVVNkEwojhfs0wKvu2AIDIcfkpmHUT5ISN005wG0cXA7DB",
            "me/mioclient/m$$j4J70npBxjeUgTOqnKcz6F4H5f6Z0qkCu5eh4uSYKEPAU0AlUhFeJQlbVXUa1BgUbBJE8Wk2hdVb9AkZeL5cEyV6cwuKAzixG",
            "me/mioclient/m$$LveLhUEl60bAX7WALwiBBIZN5yGwhMG33C1pvwVZIOKvy9YUyJNossW2UVXfWIRFy3zX3DuH2wHPNYL58n768XYHw02WMBrbI",
            "me/mioclient/m$$WnSJUEAtuWAkLbdkjHzMmd4d9Snx5f5Kd7DsmojsP2IwG0qmApVYZiPj9HKW6TFAngZYWiRNbM0tNuxCEf1F0NDelPCP6YwXi",
            "me/mioclient/m$$jrusmftlwkHD9T9Rk5ugnvYdHtz1CjYUklm3zmVZFK1krqvfTmTMMEdf9kl5V0NXEnCzDmRJV7ww3xLkirk1PELTuQpHJ4S6a",
            "me/mioclient/m$$6aCE0Zxabq36WyXbonncho2AqDWxxlifdvHsWczLlA0PW8CjvOiEAqXXqynndVvVeATGEAhSidXDzRwrWlXBTJrTE2pGgqsqW",
            "me/mioclient/m$$EMvWYqP8u2LmV5Me3KwKqKrRSMJyED3b3uUIahKR1FHz5osSiZZaeOYCaEhLlMAWxNOJUNdVgAMoYAmSF6x5KGZcd4OuJ4o7y",
            "me/mioclient/m$$mLBWbK2JQtW1i15mGa8I8IBjstgardgJfldIjY0efrxqY6m3arn3qXgMHwuJZxSSezWy3d9FzthFCfKaaHap2DgyjViXANWRB",
            "me/mioclient/m$$1oIKAV5tPQHhFZmVBj0ASBMedADh4PxmGG4KvoOrOU03tw7xvOZF0tO7ljsmh87tlJ2kvYMd2fam8gOcYn9phydcWtGFtk9nD",
            "me/mioclient/m$$FvpYmHaFNhU1hopxuaWyZiDFkgDkYX2DTRm6gDSc15VqmC6a2GFX5GtavFo6PWHHwPkjvyQvDxrQ7t9DGNjMXiPTroVxIVI0g",
            "me/mioclient/m$$8iTKzGASPuJ6CCPttxOjWdXuop7b4TnT4eYEIPZ8YmgfKvkotnCtVNeHhWRHJm0DA0vomVQQpb1fli4db5lgztYD0bIjRoLFS",
            "me/mioclient/m$$USlcBtITPixIEmxvpBUBl8rxFSTFTTYxsBCjITCZOBP93dpZeCqw5rerlibhDGExKgTeZ092eAwiUpi5lo1O0JJgGpdsNH8y8",
            "me/mioclient/m$$JeNOd8JGG699MNI2uLNCtwBIqKuqm8QICqKjwzirQ7tzFQlvzCYqn8aMGo3Os1cduMU48SCvl9pLOE8SleY17WTWotw7cOrSM",
            "me/mioclient/m$$8VWNOS27AG8fqeaTdZma0nRA48bL01U26ZczWMxl9usXr9fpJBhKmaLkkfBrLQOcfgnTXqkozes3qR45p0UNE1ZLNmDRWtliw",
            "me/mioclient/m$$MJZr9Tg8SE9jrZkLqWTW6k13OIZFOImU6sX0h5R8HVhNLbRHXZj0ad2MQD3xwJHOfEEpocmeHgQPfotPVW9GbB56EstWNsLFG",
            "me/mioclient/m$$EbuqT6l9uK4rrsjkPe9BWXOLEq9h8uQ3fVnmKUEsABY1QxMHYLaBslVA3bPw4vYoGMr5qIMXYjcwxWga1u61Ht9neRR0zNsDZ",
            "me/mioclient/m$$NmmEkP9HZBIwu168E0MRYH79vHuQVKCqAYbPUx0i837PubZchuc5Dyt7YtHd9IfW6fcvgEfnDbTczEWrJUFRHmcU8Tl3qlV1n",
            "me/mioclient/m$$i73rPJ29N5uWquv0k6KoROZ8Nyo4CFo9aGw6wVWmS7REhN0cxq650hUWc1xRBfWUNvMwc80lRteIZkEgxXjva7PhiL9sNqKDF",
            "me/mioclient/m$$xE08fhRusrfya6nxL8PVhDrWQWRIAVXJAyDkM3Co9objY7KUTBhXU80c785LU9XVSAY3D3NXb3wsdl7ria3zrezzRt6Y4plap",
            "me/mioclient/m$$Y6EZj4zEaORzEngNLldnAWMFvjLLlLT1vuJrUu8oRcjDMZrhUzYXsik0EySZuoNu1X3HrRPOHeTyvfIfbjAic0n8DZBofAikW",
            "me/mioclient/m$$N0RW13dFnRyuYNSCqfd29UUtW1a3eMKnn36yxTNeCV6X388iXBMIHWFgHrps3LysmIIKKRLH7c4z6Ip20dWhDdBBbRb3RupJE",
            "me/mioclient/m$$fp6hjJ8Onw8gd9k2B5IS0rlXIY3tM4HX3wEnX4owq2FbFXg5dzWoNCwA8OGLWqrMJGMAs7sx2bqg8PFSz7QJITUKUgCrnGZ99",
            "me/mioclient/m$$t8UbFxj1ZpxVZ07Jd2Oz5kgUR4wIyvhwBkx2GiSkdjF60AjXhfpJuZfVCnwf6K8JyOcDLU9pbnYMR4JaSiCbeCqO4rAwDT5Eg",
            "me/mioclient/m$$NMyj3kpnz25ULqsnu2U0dJZLzhSPcxTuF0CGGp7q9KZMFwJOdocG5NDhXoTCF7ePsOUsWRpPl38AQGU0LQKBzKgalKxE906u4",
            "me/mioclient/m$$bIFLEE72y4aEfuXUYmBhLKl1KvfNI4Q4SHPcohqABV7mW2vDwR4JAp6ZZld0p1yBuwkgoZl3Hexzzmsz2kYbukOPzK50PtOgx",
            "me/mioclient/m$$TQNMeSsrkWH2ENyXs2Ovp5gPBC3wYOsfF2oys47lBEvs75pK46hPYxK6lbWP6guesEjrcHQPYkJodczxHOz0bq0hhWVPIH56R",
            "me/mioclient/m$$MYg3c16Q8pf77peUY1CI42ggZ5WkI2VAUn5SbkUxMtavANk8yy7hB758UKeD51tr6fFRnggkjtKW23iHuUuLAv6dhBTPNISZ8",
            "me/mioclient/m$$J5eiz5rnSzW9PpMbyoGHzA9KxuhilTWlzXPKXjPWytqNlw04jNWfhtn2OPaO6l4D7GittIUU16ovG3vdQ7a8LGH4ldlTKAIBP",
            "me/mioclient/m$$wYwp3iJVW6CqdIblZEwg4q9sSlFmnTPKpHE3lKrhNWrtfBgXtrJ92p4V9vHf1GtdLBJQt2dpBoYCOmu5lEZvv4UM2L1ASwoME",
            "me/mioclient/m$$3BkOF1ZDQTvljPI4fuQWbNI8AUvq3bwCH1JWUQe53UIRCKdGOi2G1rFjgXJVlBpS82mmQlrDc04UBtneXYfQiFXjcwNmz5enC",
            "me/mioclient/m$$jBxo8tbJsJql2bu8RKTH9oE35YVMMJJrQmTEI7u6kVr77u22PYBlUIblbtW7nn7pSFqe6SRDH07GsmwKv1i4uFkSVNB3ch7C7",
            "me/mioclient/m$$y3L21LL0AfFouWuyQOzZStxYqxJp9B9ps3Ija1WbZ5JrHPsim3KLz3Nh1qwRSedel3z6fUbvoSOvv4pZe3hIKXI2wq9CrdXJt",
            "me/mioclient/m$$hA2RD2LixhctDyk37SIEWjKaYAU9dFCM44SqeTkyscNRjitAk6X32Uwj49KjV1WCfqZY8T5PJF4EwnJApFBr80tTx9sqaU1Yl",
            "me/mioclient/m$$Xk3WBzEauvq9sYC4bsW8PvpKP7HDzJW1GgANglB3rZK9VMnaJL4gSyzzI138p5rcoSWnDRI7e2PjyiN10ZpzMkoiaMa8HiHil"
    );

    public static void initialize(Object manager) {
        try {
            Class<?> k = manager.getClass();
            Method m = k.getDeclaredMethod(
                    "m$$H4ZB5VRjXea6ADgAn7oqhkF1jdY2RLRFdAhjRxioAK3g7dPU84hlRjGs8rjdVIiyq3olBiqej55jhKcEKsFLMteWctvBZwGDg",
                    Class.forName("me.mioclient.m$$91y4uxO1IQagfYqm9FEgYw5vvDkJrRONLQWZCs7n9wzW9fgwgnegqCayTRnSmFjflHrBYGF6ZLPzDKu4mbNi5nwosBbhplPea")
            );

            for (String cmd : COMMANDS) {
                Class<?> klass = Class.forName(cmd.replace('/', '.'));
                Constructor<?>[] constructors = klass.getDeclaredConstructors();
                if (constructors.length != 1) throw new RuntimeException(cmd);
                m.invoke(manager, constructors[0].newInstance());
            }

            Class<?> en = Class.forName("me.mioclient.m$$V6AVWEzf5YnS3nyDKHfIPoaHqQJcAOVv2YkjXxlj2z5UctHzODWM54xeqEkPrPJDoY9uL3PX8O7pSO5uhSwrukBKHQG4vQAQq");
            Object e1 = en.getDeclaredField("m$$5CILzBkgyOvYq7pKqiZrkdgPM3ndmJaqbV4bdNldib902ZON5Q07YphitvI4rl0eukwE7SMOEGblKn8aoJa8KlKoRMXNe20Sp").get(null);
            Object e2 = en.getDeclaredField("m$$6O1JAsRL5VIXFiTC39PDk8NUwsQ66iXei8fB6ouv4n0H9IiPVzIQXHNxE1Wx8UcEojUhhnEA6Pv7KnYcuQAosZPMconBcJh44").get(null);
            Class<?> klass = Class.forName("me.mioclient.m$$5FYS5NO8lLJZjgohvkN9ugYMQEOyApRGi6YEP0E7FVRkFClsNy2WWZWJp7RiLfU46gMfGl2hsxOJo0nGhv92I3OAVolGxYwlG");
            Constructor<?>[] constructors = klass.getDeclaredConstructors();
            if (constructors.length != 1) throw new RuntimeException();
            m.invoke(manager, constructors[0].newInstance(e1));
            m.invoke(manager, constructors[0].newInstance(e2));
        } catch (Throwable _t) {
            _t.printStackTrace(System.err);
        }
    }
}
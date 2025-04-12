package nick;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

public final class Modules {
    private static final List<String> MODULES = List.of(
            "me/mioclient/m$$0IjjeabuidfaVGE4fC7mHuDibx26LmskzGgI0XKh3qZxfNsNoUtys1owYDxWGrPvsMrvi1V4wFmdKH39G9RDLBMyNkXldQpnf",
            "me/mioclient/m$$SsUUuy7EjFpskiZaeLxfza48ibVEImQKULm1T4NlVh6m7VA8ETmuV64UYluIHBaMZi0vnJ54BoGj9wbnVlk0ZK82oGXHWz60b",
            "me/mioclient/m$$XNid5iGqyQnamc34viG7SXetRIye6zkWz9MarqWchoG8Y8EEAuVzrss4zZrmmsQ0uV1l2yfKU4WRPgWF4P4z0Yh2Qqa9qIfTa",
            "me/mioclient/m$$GgbHXDQYW1gsHtzpFw9ymjWK17ZTnDQHR0pXwkJ73WNbA3WwAZyrsg9mnti09jyQXPrTJxktjwD4KNvRl3N2ummyGSb3HyCwD",
            "me/mioclient/m$$mg8ZV4ufwXoP02WjkeXSTgSS6HIWFjf5LlMtoGhqwDwRFNWr1B9qUMjjlVqkFvlUxCIYfzdvAw0JQw7XcH6pW1OMoRoZKUrbM",
            "me/mioclient/m$$nU5QScyLvqTIYV5SHnKf5YKBPqULp1rPI9mePl2jh0MZCvI6iSm91HLXWESvRnm9eoKmKdkGhU9kV4K7t3FN3y2itm9XMsntd",
            "me/mioclient/m$$t2ugVaNxGE3T9Ec2Q2NabJQEVWoyHjy7uzVRc8IWMiBVDOza4z4FlYWKkEJzYAcQ3Te7LVIbUUUQgnhnOb6QDS85S4WEKMhz6",
            "me/mioclient/m$$vrXYABx4g7ftrqckhx2ErI89DMA4i0CTAIHIIS96cuyfXzju7gylThv3SzHoNv4Qy3EY5C2oii8GQ76Aalj56ZAgDEYeOknZ4",
            "me/mioclient/m$$3bMa8qAPH1MzEQ0jtyVAqSFOUqc4w4pmmPMjypY5TF3BRcFoe9mEY24TyBtD8SdRfh7Z3iQfkAmI3WJJzDTXwyPNo9nGFVest",
            "me/mioclient/m$$fm3ZccwysazozeDHgEgj6AXQb3f4RL2hol0skNLQShfnKE2g2a7WxLq4IAEqp97EF0gvBGD013JaRFfmxButOCUtdtGwgUsAq",
            "me/mioclient/m$$uU5YZNjTWvOoZulWpqs0n75WW9xp3J8mJA7izJqp76xe5zxkRJAWSLZDjj4vWMeByR8yKc07jqxaYSzHVomemSYQzWkUCw0eE",
            "me/mioclient/m$$LvAw4P5wIiQtBPNZqHmlROGj0zRKUmDL5owmtNLzpMA8gsYYUHxSYHPJ5jGOa7pC5M7BHp6JucxeUpJbeEgKNQsyWBYcQXSNN",
            "me/mioclient/m$$oHxQH8R7NhybqKPmi9CPvwZpy7oYJ9GFBrgAeA9BBQfozi6U3QOrq26GrK9PizSwKurmGuQ1mJFK1JPjLHPB9UOYReXOoygnp",
            "me/mioclient/m$$Zv1oIObWhDs6j81UMcUR2Y37v4f1XAw6XgkubwCYSNP8mKDzreoeefwZOvXnKm1N0Whp3IBTA30AH3eQR7kjQp0uk68uYfVSJ",
            "me/mioclient/m$$uniVI2KH9YyC4WFFcSQ2nZDDPNiZLnhlFPvUwb8UiE9PtI1RQRgdRV4v8EEHinm1rIXahZnEAwnfO3hPEbAAAxHFR008uGicz",
            "me/mioclient/m$$JQBXI2DoNiclvUdlwmijwxGwTNYMAJZpy24ShSpfsAiFH5xG106pv65ab1nboYRPsmd9Zjw2KqFJqc4vd1UCSIJtZ26Aj0Z1d",
            "me/mioclient/m$$UNvVFz4U9PbZa3JC54FN40HrtSWwHHR65lnmEet9Kw7ndPbGjbalVCrPRc7VCp7HhnGCphiAh1jLu2Wic9EczHh5T9zV7uCTB",
            "me/mioclient/m$$8NSuADd2QA8NNmAt0dMgsB5XHxERhiOaF3LvcTk9mp8bqWELTRt58yJutQ39XHgvII9SPlcjrs6mH3fANJzTjUgm4c1a5DUAL",
            "me/mioclient/m$$b0ecuV9Fe96bEQLf61oq2viX255FptFm8VbAVSJ9z46regOhelWksiQDeCMtqFaeQQXFOff7ZOXFmENWvUHej97vyzdT0Qhth",
            "me/mioclient/m$$cPyImgUpyuGeonxn1gPZODkub8XTVZeHIo34VeEv991I2znc23rM5cKrqnRZWfKOBnnc61GETc5EEDbSH1vC6BmB6YDPVTJsc",
            "me/mioclient/m$$THAy2MoodCylNkMwrXK7AGvG5NiwiUzE75d0cnflYHgsjrueYKK8HSkdzlNvevDmxgufMNYU8Rl08yvnYXP9KX5NNqGGn5x8w",
            "me/mioclient/m$$wVmikI5aLKn5kk6GHrHHy3TChvsAOW8DwAoU36xvHeQpXVfDxpGWECJ5jUptzAuk8gqElJSJiSjJQlwGukHSNJ7LJ7uwEjBsT",
            "me/mioclient/m$$vvltpDIuuhOU51x2u5hldL4sPxMI7Z1sGcJK6QVk2PWbPMMjThoYeR6KV4HR8cdoHffZGd3LSg9H67OJER4XwEfQOwNzwSKuk",
            "me/mioclient/m$$TUFnYrYjUMoMMBFEFy364ExZls4MPWU0RRMN8B5zJBJ6PSN9gdbwrGsmLm6P3H8Yj05bDjsYOvQGvm7HozlDS9FgOm6Zu3eqO",
            "me/mioclient/m$$olG91JzqwTeaX27XAIOeJ37w92srMd98To5zanlftHQ9tDRfqG2CL13LLAKLNRNGh7A12Oof9h55C3kpOWcY0LikjMaiGoRTJ",
            "me/mioclient/m$$p9ipg4NwHpvS5KrTS8suPu7857ZVmDoVUXOGIisby5ap3BAN3PdpCFS6vcCWnuOMEnqxIkEWHTXUjxp0jyzCvtjvcp9az9EfK",
            "me/mioclient/m$$CiUfele6rHjFIbPEHBsKIPnqbUD3gFk2kqtqxs3PZ0DTn1HoHAqIpAqzW0ppwLTLlbqyINDvym504HOfivcC4BHgsBJeear3P",
            "me/mioclient/m$$vMMhVgFdvzJLYJVxttRgVLpJKkNRkpIns4AowlY1A782ZFEPmXnJdnYG1i1sTdHuuLUubHGNo8EtNxjyjFD5cM1H9CIRUvcHh",
            "me/mioclient/m$$kvaaAZRfCPy21xXMMS5AxRdN92JH519gRny09FygmwmOkDfVlh3NeDvjGuv0aqrwSWnIVo9PB0hgxEGJdXCj0UOuSEvznEXd8",
            "me/mioclient/m$$BFkHXsQz2qaTdmVjycw8obBeJWlnp28ZpY7E1MzHmQUWG5iG8fIUrCE2Dm3DRMroO9HhXYhjaEcT8z58VQNP3sLtqnlxXOUkg",
            "me/mioclient/m$$dxzAEsccvOsjB2FCTbDhhdHgmOT4QYBnuhEUta9DjOM6QK9VSmxdRFBq1kqCJtlYSr94Aotha2uuWaEDBGDfCIBhecnYqGuWb",
            "me/mioclient/m$$h0neBi0TSx2E8QBAOyrscdZpVrVFeieuHYZatBQZCGeCcuEJgyTVVhTYcPslsqlmcy3rLsFxe8znHqPElP1nvtmkRmaZI3EIr",
            "me/mioclient/m$$8pNbO0t9kahsABY2wQyrTSeKGaPIcGlEa5aKCT6Ic22fYXdG9jG0swWZ5GlKes22XVVswkIrRN6xOSpY1o83jKVhnW04ZlI2A",
            "me/mioclient/m$$MQi7sw5VuSdyW69opOECH8B5oXNAKWSXSdbD1FnFolE3yPAFbnizsMNwKSN0W3tWoCtp0TbWnUP6JQZ2sa2n8UNVtzTl9izxO",
            "me/mioclient/m$$X4y5ELuQIpaUUnwlXkKRQbfMTk9HmCHQ3a4oshDLSbSQGEJB2Yi2WPemcy7nCfF20N1xzESaxHab6hhQX8oGO9YRT5whKfwhR",
            "me/mioclient/m$$K6wyUSwwDFWfEp0xOR4yoUCtH7AJbwHsNdS0T1FUj5p3KzSGOpQRjwrF7RHFzASJk6HCSVK44EFspqEzBQtLgyKIzcYsKPyoJ",
            "me/mioclient/m$$WA1ZCkXS9cZBPRFsdU1nd8qkOQpigXo6IaLcyTyGV2TCt3u1p2ch747wPCV4UcKD99NYbEPYKjENQ0CraH4lHw6nbzKoloTuY",
            "me/mioclient/m$$ER1cmrFoFraOmVo3wY6jsdfmUjkFe37QQrKZce3QcSvFvS3XrmaE1aKgLD2R5TC7okXpQJDXhu1qu780akQIEGUQlmAcJCkXA",
            "me/mioclient/m$$wRUCnUYIYfQgfDZcqDhKaAvfKQDm0IQb8HU0KvVZKdH44BxrXFrZzKNz0Oo3RNIfKBai7fFOXN3kPua62GAOsynh2ofGI3xP0",
            "me/mioclient/m$$9xQtIiAQlYU21915UvR4gKdecEy3wUO5h99FeXzM1X3Q0HF1qjnX6KbtMHIEDYyL1rfCXPzsC0JQK58bF9BH2PWGKYnfwCa7V",
            "me/mioclient/m$$7QBoB2Yk40FwepqDPUvk7lM4t2pBKJCyWmNIvs7FI9ACNH3c4TNLbUlLqOlTIYsCJwexv4kLz0KjKfxFiWDznYstMbCq5XVxn",
            "me/mioclient/m$$gr7Ez2VZDimWb4P5c21NBlI7QouRcYnU6lcU2JBjehsUSCpMk6JfNL7yeRHgLdD7cq8F4uP8Q03xO3cZ0fnYZVLNfEzDkTVrg",
            "me/mioclient/m$$5KlEs4XjZsZ2o40BuuYuh5Am0D50UmMreSHmNM2jGksx1a54zvmngLEFLVOroqgIHqBQOk1We145BRnE3Em7GqSBYN8LO9Gef",
            "me/mioclient/m$$7i0rPjdt3w4ZLbZHr09oI8bX4oZPXNPmZWATRnXFVtNACoiKHMrXMULOFTmBKfKW8c1ny3MRwAraKSM2TWi94COiUYcIsQiAq",
            "me/mioclient/m$$KRW9fHTArycljk23rE8Km34HVFJIun2S56TnnPKC9RESK58GPXebeLajZcRGySREj3OxLqJbMiprWUQL2zJYyTQ4TTlO9iPq7",
            "me/mioclient/m$$D2B2WxYEQBkhgXFAoZ9nScSI4r8uCzm3f7GhmZrsZvofgJAtPB6fpq0F5Xrbls0uZqbB9rrKDerCcM3AlTeUsHTXG6uY9fQNQ",
            "me/mioclient/m$$rhpqCJbIuocPTvoBSRWEtbuGIT6nIY2MTAHKE4Ot9lwM7BLBe1atzD47k9ayV2RjidwnBfrOuJDSdR58SdYFHUPl2gAlOEuRs",
            "me/mioclient/m$$yav0Au5Ocx9NZCtDEkR41xZHdm2PEWQXbTXBeOrR3mTpA6CrjhwMU71ZRciQuL0XjdJygVDxSwKlZgZwrYd5BKOdcu7pPMvap",
            "me/mioclient/m$$0vmkbP5MDYnWKZehVar64pU9MUuykVNE4oQ4EIgNzNPp4omtpdhgAkrYoRxZWiHW9kZtvYkqAvdOX2xKTRVOVpwDNHB8wNohO",
            "me/mioclient/m$$2MpeKmFHJVaviAB1F0K6e34ToZPRu0cl0RztqJ2QwRdKuWIqPTtGs78Lf100HGDL2gO3a5bsW7eeKEloC76MgmCT6xiQrRc6H",
            "me/mioclient/m$$BNesvtNZg9smQAqYQAWHXJk4wBlT3Bh3472kYAzCUULRAT03SGFsFN4kD8u9oqclDhpppu7KgbZ9eb9HLQCidPfZ4jSkHmg16",
            "me/mioclient/m$$7N2XlCHzhILzkKQ5eXoK1wBvxqUlA0yrrT3JjDEa2FINwuGhp3N1VgE8lMo4TkQj86NTfN1Z9fEvDEKINophOzZkiNGbpFUHD",
            "me/mioclient/m$$gRCBlZT61A5nUg57csqxeqsYCfWd0zCrHZIDjmdQd5FPV9ByNw8kvYu6cQtgfcj1iH5xX91qIUvOzlNIeOzOIxQMCw6cgLiJS",
            "me/mioclient/m$$1WVp6FSjruqYVTTE31Sjb4XmXBkrWN2DRvUt5DIMxkS0aRFe6PRSGYK7DztutOIzF3qqcvOiPearj0ANjKVVRIRKPBQOBTPBD",
            "me/mioclient/m$$IsSyTYBWhClUxW0sJvTpjTER9p6wt3OJwZH5t8FI8tWwbFiEuiqRgz9Myr957w9d8NsCVwxzhbpFmemTIZISrfgDCnV3jLxgJ",
            "me/mioclient/m$$4801z4VEhea5cG34VkUD4RRHa9m9lzDHpHOFdAFvgj8GvPDyX2v8sqXakAAT1epA3JP9DzEUo82DEbXozeNu1SWHUPYxTBCoL",
            "me/mioclient/m$$BZmi9GzK3bWLt4WCi12seVDYJYQdINIYW4WDDxnsO8RImapK5x64CmJULL8Z0XVvvujUjBHSTXWffbY1xOIbYunvGCEZT666K",
            "me/mioclient/m$$1YE3ggCvc5cKBBCMQaFWvMlgJqDLcQsjp9KoviiyUqq43gmTCpgnOBDHjRNqQ9fxSeJJrk6VJSoFbIZ8bfPJtRgniPnVdLhBh",
            "me/mioclient/m$$aMJ2Y3YGJlH0ZZlesk2owMZ9GqsguuO61XrwsZLtnzbrEiBvfhEgZFLSgXtiI5AMTW4MGYXcsKMqnp36nBRf13puammRcJ3cA",
            "me/mioclient/m$$yIQLx8mwJweTSz4oXB2R7oeiKG6qKnfZ8Ovoup5YlJ7arvdGaxXnUAoXHll3eJHjcYI8KvA3ojmjPUEX4n0aU3ymnd7ukjCTF",
            "me/mioclient/m$$QEotJEEi9TxCc3fjU9VcUPfzflgq0n4Ku9B71qZKlRwevotisczAmlaz7JkrRekyaP1Wmm2yK0WLYj4rNoJlpxGTWYyOmoSk8",
            "me/mioclient/m$$x6qdMx9KLEqVk7xRQRMq0eUzXX12mdixGxvrYY4WPO7JKpOGdZBqEWTogPi9InrY0rJK7BOp6b1jJVoKufWp2GZeialPmkI6e",
            "me/mioclient/m$$jpRGAKnwAZ1cwpNOv5LnUBT4WaPfUt0iNz6zrxeKtIJWwEzm7cuUHz0Hp34UX73HahtIggd9wKq5zqbJWtrWQQMWZuveiJfwC",
            "me/mioclient/m$$r3WAErcVq6XiFehskR1AVxHhP2zl2iXXyrL2LCLpoKaRARYLyCPzCYy4YNgirShi0jRViTmCDujdazgCaZKUgKAFUIJlo43rT",
            "me/mioclient/m$$0bnfwp0cHwQq4PccNEEqcQGtGed0Co6kyHv5e4VgMAd8lYjACkC1yxqedJuPYIgTstOxqzO4pmLmEBFHWYhENThgi9UIk4aJH",
            "me/mioclient/m$$Sv3WNfYHTjzkcYDETcsfrtWhHTv8qbhDKk56HW66aFiKYw44TQjjmnZjxQO9co6a8vrfExu5rHePjFR8I207ABJP58UWcYqFQ",
            "me/mioclient/m$$bUZdvx66TCkDH7yZSUR4h6BBblGqBOB96CaL9HJvB9ARa9ZPlJXF8vB9m3eX7tK7r2gKdMzRLDgx4JNXQwdqkNIDCg8Uo3Dt7",
            "me/mioclient/m$$fXqzqLRHhQwIiI3LMBz2l8UfAiRGtsdxNrkdH2qQq4xciN8XEkEQKWOwBVna9fXMugTxkjcdpZ8E7QPQ9fpgZ6NqushAKiNPJ",
            "me/mioclient/m$$6l1Knt5bGjH3Aih7gR58D0q1WrqiMaNoEQX4Lr0XAV31EGQpQz0n6uGmXicsT76ACLz2i6o4rRVV6jJQDh5xb0evmoSDRvT5Y",
            "me/mioclient/m$$7EqsoSKmkrliSHvTECg4ntMNYkW7kPrPZVMAYwodPZwumrASkBF888cmTJK2iHKqPjXL3QQtuodjbYynKAzZgIbZwrwPFfOUU",
            "me/mioclient/m$$UlyeRHvo0MKQdFjHkVjj6B2k80FSDiw8wkdoQBaQzbaBHUnaID07GEM7XqFcS4vMkzvuwCLaB1C7ouiiCnL9KR2wc0sf4AQYX",
            "me/mioclient/m$$zuhsLFyas03dMWzf11EMwlp9XEMVT07UDKyHoeCDL5ki4yEfK4JylbZ2cdYzRfukdjkWYuBHbnmkDu6zOhv3q6qd8QZ2FihHC",
            "me/mioclient/m$$fQ0EYeaMAtuW0h4FcZVYi0mfOQOiaRMAXPXmCc1L9Jgc0A1OqDiUKH1uBNl7NYVFJtJPAHDXqT4GkWMXwiySpMqb7iFlZlC2Y",
            "me/mioclient/m$$umHCJEuQnTN5dvj1QrJfKu67bz5jaGXzd7SSBQbUNA4oiFIaQgqf4KNRW7aOHxfz958unDP7zTSmyr349cmmYtXD83ZMiG6ji",
            "me/mioclient/m$$XasEd7XTv5Nv0T8YMd38j5W6D5I7QxQwPX1bine4bzxYteaaXsPICmuJhaG7oqhj3uqlx5MYvOkNl6O6I13ecK0HlnGAbcYK2",
            "me/mioclient/m$$AA2vZVSxdeYwiWcyKFohLO5WN4yMBaUrkVyA0fHT3NwprtIXbkdGZ7N8tf8ymM6EaSPamifEDoexazopnF8i6dRkSIoYg09SC",
            "me/mioclient/m$$q4MUMpWZ8BFzvfPZIaJs7hJkiqKgploibWq7NNTbntoSJItiLIr6ylBVBzOdMvc8ry7KMssnQYr4qHrX3LBnhEgGjPTdLN5jD",
            "me/mioclient/m$$o6AG9udCY7jLhm3TI3mtgXVOIU7lY6B4DSO4ggmHqspoMI9p4noUte3TlGBLk5UK5CxfQUAq4sVi1ZhB8QZAm5wBxvNCobJ1W",
            "me/mioclient/m$$IHBX4hCuwZ2KeSVmCceYZ7356aerzs5mhAScCaieQBzYEwMugPsoBs3M4K5850Z9vEXVbyjepncfSj7kaDts2VogYfZg0Cd9g",
            "me/mioclient/m$$IVw1jtCLMtkUoRvYGpdiQXgtgj7oYhlqxbsfYUqG4vox1S6EN9BUcqEq55VjMD9sYbxUv5vN4EkGViCufSjcR45q2WEIJw5rT",
            "me/mioclient/m$$3sZQWbWLkp63JRTzJRyeSi2jaimOJKQaIBHUsfcumm1nb47qZlWQCNJly3ZjGdCDUbv30fJb1p0U7quxmxQDq8aFRhoVJNtru",
            "me/mioclient/m$$z5VLREeCOJBwflo5HyysYnErF7aP0iN4iG5kwQs2TtIuKgdjjxCfuAKxgtWchxzeXoyF99Jl0xmiYQxDOZUapSk0q5ZOCSgW8",
            "me/mioclient/m$$vcLPl4B3jg66NRerdJTmmlw3IgctkhdcjHaL71hBovrQyfViELZnJjEvG27AYJpPwFH22MECpeE3huJsve9xbG9Lfgn83LLGe",
            "me/mioclient/m$$OjBXc4MpCDskGWcqoB4kVP32pl4ZG05AoJNRl4ko1tDZQv7mIkmlayyAZxMf6ojdEa9Tf67RZY2V4QHrDPy6e6KLrPzs7Eg9z",
            "me/mioclient/m$$CsGTmLXH7u7LSZ7noI0XArGiMK1qhTOEb2Dqb0FA6du6wjOaEAgusrcdY91pvaPgeHIqg2PBz4ByfWvLVJrtT7fYvwmpzrnJs",
            "me/mioclient/m$$9HeBnT4MwaWiXhu5Hpu69GJ9RzfL4slkk5jtAfcIgmjyJI0yqPGpXDp97kBKRmEjwCsYDqt6hA9qeVn1gSHK2nIttgqUhBURU",
            "me/mioclient/m$$XtYve1fvgGId8Moo0cOCBGVeZzemFbzoayfmhqmFJu2iqXmtCPguRydjMcL5uejCJSjvHklF3ZzyJGVwVU1gppA2iGHp92VZW",
            "me/mioclient/m$$g9XbXnHMG0a0VYV0tua5302DVWiWXgYUq1rNsqjxU37zxvGYrDcghH6bV2Jg7NGxzjZ7Qkl6XquaHX0ABUoaDLbu6hcEctgpS",
            "me/mioclient/m$$SrIaQWjRYdG8uk6Bmb5gn2WOm1lJRqRc5bf1DJY5DcZPPfzzOeom7Ex4nAWue0iuo8iyU1xokiH6u7V5eMV5BvVsP7r5vvWLX",
            "me/mioclient/m$$8PC6rIQ2UoXGFzAZYNCYQsvsuStmuVbAbPjQFpPVsrg88aH6cvE6JgGHqN38jVlZJoDTS5qHSgrBTdPbGhHMjx61AiizjARhZ",
            "me/mioclient/m$$q217PStIKcbTlZwngjFjNOGLl92yptSjz2vGJNZ2BNceCYFfdwATSxBySGVXrUcyGtGDSJ0rHd3F0xobdypELOfPunv8mgEEC",
            "me/mioclient/m$$R6WnSxhtzNPRmdCaFgNANcblZmX5NNrIpiT3w3qTak6mN35CYfe53xRlaOrZ5hgFR1cm8yJizZfGHy5YWkPKTTj7oqib8zS89",
            "me/mioclient/m$$H6nKSlE8LdisawV7ylOEqLonCM689VsDozXybVjRdkXfa0FCP7tKg2sXMHNkWymIVHyedRtsuySfUfkojMC1WFmvjbVi9zKG9",
            "me/mioclient/m$$fC9RaahTKVIm99Y2ui2M54p1aMABwaIwDimbgoUg8e5LFJwL7OETW1Bkd4fzBH6hMzvGBFnguMyFZkqTQG3sXhZDlxGIupeX6",
            "me/mioclient/m$$PTNlEi7qW8N8tgAjExNRiFLgSifMoFFedA0mtYandcvbykUsdft14Ia7bgqu6fZN6GWswatBzvMTjfBahEpE4FkAxDSiS4iKk",
            "me/mioclient/m$$NWsWPUvHO9dknpRu5e2h1ajeQgDToaI6QmX3lxaCx7MgEyUog97QuHKfrSLB1XdIabPe4hy7tVCsuXn07EhMWTFYwSG74r7Wz",
            "me/mioclient/m$$hqmxzXhy42DsNKpBPG2CFuAbGMckOj6qGXCEWgFXcoJOG7geiJw7Fbn14S8BZGMKQkseWNHbNuY9qG4cBkOQOFK8rmddUPo3z",
            "me/mioclient/m$$aWA5kdT1Ie3rb7LlNgatjfaP9r7p4sUqqrt8sdKOx1OS62pmtlU2Gpe55t7nM6T1ua6wLYEPtxDfN2dWVBvOGJ22qYBXQgG7R",
            "me/mioclient/m$$Rzyv0KDtiDl7oadsY3uD07USevEyiq2b0NjqJfQ04fg3alNavAquiQtw9QrNY6WyfptRoEUv6jdxgzQZsu9ggQu5lgOWtkjRT",
            "me/mioclient/m$$wdRDSinQl8YLT4P1eIJRKBdHgfmV1krT0mHxGUy8Y2QHMAIUeYmBZIQ0w2H6bGwXUvKoDzJhEmB4X0aXZQS7qoX5tWuE7pYjo",
            "me/mioclient/m$$Eb4miErUe54zhTJFJ4jsKEq6m2NhAAcfh5nIob5SP7hpYaDtHiKXOxSXPxEfbR9e1nhpSWdF7yJLeNqoyUcnENsnbXieTv7hH",
            "me/mioclient/m$$lV9kHkSFiPM6YTZFunEU6dSqFECR9Z5jZPa4TccIOCpsWYpBvaR6fTPcTJcdlmGgjA9XnR76OZeS3mGX4vkLJyJSEloMOXfGA",
            "me/mioclient/m$$yrv6ezFfw54a2zz71EB1pW0QGy6NruOIm5Y4LnJLopCqBIA9TQWHkFXiCExCwG5iKkiBxPgTf4DzLHeIHsfXDpF7J4RchMSWo",
            "me/mioclient/m$$UvgGyGzJIxSUtNnADlRWJJUJpkuougvNmJRRWjHFQNmLHpCf3dOfLyLWY0xoKstip6BKzHBALYMGctcfu1268yZxyJLSCX680",
            "me/mioclient/m$$lFc71fclno8eK3Em9M8lmiTAtDyAU67gXqNw2cUKwwM4xbNsZ0AAtkDTCNclFsv0DkUnZl4qAUHbvktUKN93g7iHLe3diGN0W",
            "me/mioclient/m$$hfyInxxxG4x4YL6czNMjA2XLAZs47mlhXA6NwLXdEtxA34fbtCGH05gc1M1TACq2ZeyZnAkqHK3NjVRyN0okuFY1ZZ8TSyikh",
            "me/mioclient/m$$wzH0Ya74TyBztk7khIoplBH5uSDrjd6VJj4CfPefVCe3W6dNxxhqsqeMH0r4jWjEhBQqNqgWaBrb7bH9iFaH3ccUTGeWPCdCl",
            "me/mioclient/m$$N3hylLewsKRMARX7Ud0KGQWqN0BPgUsuOB6RFrOC8KkmdWsxvMeWMx2213PbbZXwmIm5T9O8b12kDpsQuOuDZTNqrqWV4SDqu",
            "me/mioclient/m$$hNKW1ujChiNzqWdlxG0LX6SgKrwnAYnU7asSD1DliDCj84aUPHHNZzdINpmqg0Oge7CuILHaVMTR6frwuYvi9htpFMyY4LTTQ",
            "me/mioclient/m$$0hUhzOv7TfijidnVudCaWdlofPKWg0fDlaRgFJfExyWDCVhvJyJB7fqQbCMbHm1p32nRt3sRZNfhvOfQbyLGw1n2JNunKJVIg",
            "me/mioclient/m$$NELbCJvr3699Yzjk1z2uxzfWnCZkbyCcugj7M5YJRdCbHde0TUXxiyVcTpUyKffhpxCvpEctYjNjH04zg5AdcBZHNejM4Y9Sz",
            "me/mioclient/m$$BAQb9SiyAWe5HbAe0WpqoZybSyVfpfmNqLUwTxU2bY3g0GVDShf8dr6jA0mA4Q71GgiU5OX27bThZ65BET3GxYRIcoDwco2SZ",
            "me/mioclient/m$$XHZCdd8E8k3Wgzdl6P7CvWyjOnSeI7FbH6vTSpZpaM7OIOeSoHCZ62jmeNbjNcAAPT1Ncby3MdKldG0KtLpxVSNwi9mI7ARP8",
            "me/mioclient/m$$PidS6Cfzu3yMOngyBIUnhDLT9eaziKaAdzYw91DvqPTRnNICieZFHIZMjXt2E0GPYMdPO4shBgj5NFvnd1Ig6ZmegVzIJtUjz",
            "me/mioclient/m$$qXuM9jOhJNfI7d6yva7yV7bjFe6GDpwncgq0W4u88UsRYZRDLYBj3UY820WXFl4wOpStcxgaPnMqMLBVZJte2RZOLzBACu5LW",
            "me/mioclient/m$$HBBoEXgC29zvmipvc0uAKqxw8dRpc4yWZ5DnyAEr3z3Jl2c85POKmrZIg6bfe5XrWVbo8Jk1tS6Q4B19GcW4niKsRmse4GteF",
            "me/mioclient/m$$O1In2acUQvMhsyGvUMUrJEivYR9tyjgfp65WggGz9IT1YMyY2gL7O7qqcgR0IBHQz2IfnX0xMlRfEdS3GLuMy3AKvUO8JdM3O",
            "me/mioclient/m$$i0IzHBAlPXNZIGftaR9YScllb9clMMe74sycvIi7FJZi0IvQF35ezW1sDpjjBuTjYYxe3dScJaZhf10i6x3ktAqL48rE1589f",
            "me/mioclient/m$$KzXKNgyqsQwuEyah31VB0jV5bq5AGHs2RWGWqoEK2Hcg9GRgi8FuaoudOvY6GprALXehdvIwyxwQx4d21XisdNKVEzh4Iu7xY",
            "me/mioclient/m$$zJpZiojLcxWRbcFBhuIAZrx7TBuQ59XMX3iv5Gp6Xm9t7x0mYDsb3bwpd4FdMd6WQpUMmGz3stTKsVllR2imaQ7Fr56Nw6OzI",
            "me/mioclient/m$$S1vt2BQRDMcpw2FWDV4OpYtXOp8c44BwLHs6HZOKgctwsbWzqLErPQX9oS8ORlooVwS4TREbhpkKgYXMZJZKplUhE0hzeb94v",
            "me/mioclient/m$$IKuUAnIHgFIIINtKzFgybJ3zs9aZYTuGAsxJSuPux9KjAMYybKjslo9CufRjZHlLOdw92oQYIOvXPv6GXvbi2URRfchnHETUg",
            "me/mioclient/m$$yASh1OKUnOgtLEcVuCvX8lYiU2xh5v1qyxSOJeR1qVKZHiO925kaZ7vLewSEiozPxVuSo0byPbG2rgH79zTTShUgh7HCVpY9l",
            "me/mioclient/m$$xhgxTIJ6glF5uH95oEjJSTVmdrphZARKsbYeECjrv8hYjjgmSJdDls61IV0maFbttAV2enj4SUyvWS5txJ7jDqhum8wZnuUz2",
            "me/mioclient/m$$tw8PEJJLu24DWNFgPQSPlL2BjmNDCobJEPQ09SYzCwpjChX1J6ONZsM8wnlfz4X6XcIWZ3CJMzX9hqye8SucF2nDDtprLOYCQ",
            "me/mioclient/m$$gvuuISaWk3V95OsZlmBGPl5otn3oZMnS1nVfochQtGiJgem0XrS4UJPFNYpslbo1EFZtKV8ThNPTRwrYUvbzL7ivLVvevsxx5",
            "me/mioclient/m$$QiuLSYMaLDHTQWqVFaBQq4HctYLoU1M8jNVItBn1fk101GQwgqTw1iuLqfpEKo1VetG70AvUoQGArlzuZRUVQN1mUQ3LAPbiP",
            "me/mioclient/m$$g0h2k9JPBkgfkhM067eP4RMc8gNsflCpVb9S2cJmOzNr4kOvSFFGfYeGkGkqIQ8X9aTzjky3E5uSDFZ9U6fH4OKyw2VfhiRRN",
            "me/mioclient/m$$4Yfp2nEJo0eKX2RfYaqwGEhwj6yzAj9BpAvymYzj9Xwl67sknHE2Faw8eVlTfnlkok94lXd6EsZ97nBM8hudjnbjFnaGuetzb",
            "me/mioclient/m$$ChUpCR7jNvnuxw9IqvQZUF9OmEAvieFPh0Wbp7RQ1SdVpKsDAk0aJRRLAwtmlCukCc4GmRpUR3KaU0TWcPzlEDvpLL7c2IZiz",
            "me/mioclient/m$$EMW6LVzkhUYGpYBUO5FMoSDpZemIcsL4slSvRCXd0mVdVEJzcYDkPmWyBiYd7vPIbDXMkCj4UexCdcaZiimZgN5byrQewOOdp",
            "me/mioclient/m$$537Zpg6A1Sv7uW8SohCB0oInObbiBpGNBTHQG5msRaPmkDjeEbPO0ubyoR5YIx8R5XyjBVsnCpgKvx8cCYh6MlWHKCdN2RaZu",
            "me/mioclient/m$$uF16G4JUkOSfMITVze2FMtC6pm4QihuMGt4zwo2d5Blejxx3xREE8ojiBYwY5ziBHuqvSQ93jPf6B75l4giKnpGDFStlfxXcS",
            "me/mioclient/m$$gtrOm8wv5kna7wDXSrovgfdneDYciJLy4qadReFIwMVCIQjWKDsmkCqNQ78RfpFKjRhFGTG7FqBSNmCv6WFI8hvrj1lVBgUAq",
            "me/mioclient/m$$uc9A4VKIxKz5kqBlytwuV6MKW75dH2zuZYZnr1W4edbKaKw7tu77qmCjqzrJ3Hc5Fy5sEKBGbu8Uj0fkyKLMhT1qgjoVBdRDZ",
            "me/mioclient/m$$UEVvvsJuh5VG7BVWoLR2m3MBSjYLc1iNH3Z5f9JjtbA744bY6jnralwTyfqLEi6nu7fLUEnMBWZwtuUFQ7jV6yVHYBG5upThL",
            "me/mioclient/m$$CwWZ2RIbDfIn7jT0VCYevCGoLvTawmCEe5F6MIne6HSCJRuDWDUYDr2kKGC0PeMn1JwEe4eGWW56alXXrhd3pn9FlDd0VDnk5",
            "me/mioclient/m$$G7VafhcJmGhb3IWGuduW3RzHqUmiWIqbMD9HVwkIKktOFyAigMQc3EiP2nEBE5yoQ245VZegpUuQJPFAgp32cuh4eeApgADtn",
            "me/mioclient/m$$gYI0ZOrqswxuny1pMeQXX2GIiTeSa2eFU523rRffSA9iuQZwwGkZdfvlIgYAcaKio9mw4TfyIsWnd6CUvelMpIcUs95kVUN0a",
            "me/mioclient/m$$d86b0B1Xy8b9fiHgbekNboMcEXxllGRjTRx1NcDNtbb0JlDihBs88kNWKQjhNRPAm2wAxjTN3pvFaXEWLzfODL5BI85klaKe6",
            "me/mioclient/m$$kucW67kLf7QkhOLEmYbq34cIJGKHXNtaajg4gSDJ8gh9Hc9s28zVWmHMmpI7amE3gHUdoSmi9LsvuKRAQ2epayYyYprJQ1w0X",
            "me/mioclient/m$$d59dM0hZZMTHApRHIygEcWI9EzJARSqFIfe1ABW47KspOjZ3rYgXbZpYlmFNhJxrIhWjY5yM5BgPWdBRp7U1bsMSBeLvBilXN",
            "me/mioclient/m$$GZksVb1Ug6jduNjNIN8iiRKwMMHhBeh5avJSQ1WLEUDCUDeKqbx2DWpCOHwICNaK4LSd6usJGnQ5yOUhX18USMVKr2ztsOLCF",
            "me/mioclient/m$$6NZoHcnTGl7cvIzhlAlJGjH4fgKOYaGm2MgtF38HpJTusNgAFmChbrdmrzvWQRQlrARSCxTv0MTGDOSOk0PwVQ7KRTyTok5Yz",
            "me/mioclient/m$$W1VmrRAAS16gsE8m6v8nxg5Cy8rkLsn5NTq5aM0RELHTXkPmRnSXNkf1HYk7iMGt7E4dUJ850pivdbjNnjFVDHYzmEwWrfMzo",
            "me/mioclient/m$$8xmEH0Qc6aUwvkjkTKpmC2rYKsn2ZJ1qjPlPpEqzItF4cpNtSgU874JyPqCevNCFK4GVDoOkDKmoMR8trhHkZFdtcV4C360ap",
            "me/mioclient/m$$oT7yXcrn2vx0MFkbLIo6ie5wpfhpMoW3P4fnhPI3kNl2T4XOkdWz0vVgZ5khEPwIL0Srnvk3du5jZJDMClAL273kjyYXI9Vpa",
            "me/mioclient/m$$5Vz1tYVt63TnI4e3WMjgrp6U6wrZAQWCOn9azof8S3XeMbQCRynchLvbhxos9sYqMY5uUIxqQrvbR9UvZk3T7wdpUAIyvnZe6",
            "me/mioclient/m$$NXQkRUWqpuOuRIr3Re344dva9pEgg7BamnCS4HIGWWz7FlJQjaV03cq7moiBqnSsqoKWtCYJjUR9rhvUa8wLtXRu1qCfv7jqV",
            "me/mioclient/m$$ZC9Q0UOQjXQXRTQFkZnVGbGkDQsIIv4noZdqTSF1A8SsuI10evBsLdiy9woLkEkPtglXG8HBLqxgcoglZ0inLBp5OCV3TQ0k1",
            "me/mioclient/m$$ApEa3jKEkhwZVZUW2Zl51vx6HAhA9vVsxj3VO3nCbdLVjp9xJqGKFtLSgtreFXf00tWdt4pIbXcJCSmpycMpjmjSLCNBB2AT6",
            "me/mioclient/m$$fBplktu79ovhRylG3tGYG4Y1OcnH3HO0MMbshYeZjErrzv2mIXBpyG652upygzPGPlQERQt5X64kgSf8CzyVPhlBzKRH9UyvS",
            "me/mioclient/m$$Ifxdx6jchmqvuXJ8Hp61cwTHyBTBmSVL9Ote3aUuR4ZM3qvyxZK07NEw61bBjqF35UF7nzR4zS4oqxpmjjs7HvyukywfQQAK5",
            "me/mioclient/m$$lHOlPcIP5YPas0LPwQZckh3bzB89elu8w4cYsZ7WOETuNNMLPYWejp3dlLBQNm3NBbyOvWkO4DatFTiBJ9HniRxXl2l2Y7Ncs",
            "me/mioclient/m$$ouF9H0IgXA9OtoO1AE5bJsfN6AcnAAArjvrVFDDHtySyirBHVsPNl00pyfxItUO82lZY9AxY0pxyd8Tu4RPFOjzcjAGjV9j6F",
            "me/mioclient/m$$cAiaw0siRkKVw6DwkQK3Br6TGkOXciGdUl6ETQegFCgjUYdED5ur1IpSXX1yUubBpLyf9s7uvN8dzl9Pa3f2KgmxchgC93Lds",
            "me/mioclient/m$$q4KmIi7QZtCzXs5vWzkWiI45p7WWjb76FUNBLcTd9yNbaR0YQKgCY3R1ZCEPD2FeDk9H7AcL76ybJpsDK42z5DcK4a3oPAF0C",
            "me/mioclient/m$$Hmv9NR64x2Ptm5HLtjh7iysR12VbmTIKybx2bvc0lOyYxFb3xk0pD0QYwGFFcYw3Rx63GLQ4jJMOb6BPwgfbtn4EFo32mbGPi",
            "me/mioclient/m$$pmmzAA8FAf3Gi1XSMwyzTUCOzEFqMQug25mSzsC0PUhCVXJotJi0Kqr0yQq9gjyeykxPcsDU6Ke63czT6no5ei1FFAE57KWk5",
            "me/mioclient/m$$DkW52EZExGUlGBzYklxb3o0B3u8XwqUoxOQpwWAOcfiEyKo37qUqjt4woWJgZKRU8vKT0gX7PlVzjw6o8WrzooNllIMFHW9ml",
            "me/mioclient/m$$SoYN81EAm6Khc44ciCopqKXAzrTnK1KghvyrrD9swUcgI7kvmzVJrX1pEScPYgfrEfA6uhxoC9LUXHw2X1wV1dScUvISd9Ku2",
            "me/mioclient/m$$WX6SKa5277yepzvPhDcmYwE4jkioizcqxtZUQJTkoyq6zfeJc0Zsbgt6804lwXtI8swnThcgreDZziRCmw2xXMHKj88EGnEgP",
            "me/mioclient/m$$CeJ7zTZQ9hErHA1YyC4oSkDaPXueYZJh3WT2zYJlG7N98czQ1sVfoEdvynukB2VlGDPhhyfIX1WiHGpnnh32bX6oycaBTSxvg",
            "me/mioclient/m$$gZKM95B9YKpUikaOIzaqE2EQZ3qKFFY9xdZelkIPr7qu6N7ooXQwLfE6jQsp25FrwUK5G00KNWP52d7z8l2CVD8jhN1KupCw0",
            "me/mioclient/m$$HYaeat8MTt2QIBrPbqqzyyB7Y8MKpEzduTg9OidAYAQHxMtVsBdT2kj2GfS8EDVZlEbQiaAzj6cm49U0SpBCB8ULCovjpyhh1",
            "me/mioclient/m$$zQUyfmI2bQxpQXOLSX7eZjrbH9cab5o5GgLzAGA5FaNHBwtAuTXE6RKcRHtgyU8gflI7Zzx77Pyjq9hP6ZnzfSwJvB2lpkp3Y",
            "me/mioclient/m$$YQRjXWlwzHYjCcApYOJFwiYsea5MYV26ZtkBzHsbFhImS55omrq14pQ57s6mM5JNXQoJ69dCwdKrZQ4QkkmduysMd9SPEGwDU",
            "me/mioclient/m$$SP7VZoXgoZVvdfknYS03fWKLkndFA7xiBA757AtUtyw6FzUdoRGvx8RXQRP5y7r5eiZtMNQE722a9IHmdc7pt9NCi8kXYnNbc",
            "me/mioclient/m$$Y8RS1QPv6lUVlYNlMeZdaDfRVSETEhwTestmyjyUfJGmJC8KoFd85yNPxPPAwLw8X23zw5nuTlLqwHh0HVAenz9qwrMhL7uIz",
            "me/mioclient/m$$IEAAfs1YKCYw663JKX37FH1ZGA2J8pZnt30E4b87GPcMqHG978tCw0lPOZ6SwvzGKegdmdWTK9Mhtafh8Xn6AQzZx7zVlBrKD",
            "me/mioclient/m$$pIqms7HpWG6MpZJvCstw1lehCq7S8Fm5oHZxE1oj1sFUDZi80HHtQObj1L7F6d3iDfykD9eSP1yUr63GXhbwfJvucr182sVDB",
            "me/mioclient/m$$SPykhIwJA36ciXKPRjRTJa8LsavrRDsryQ6MOjO7fqOO5x0vaeGv3nQSocxy7VSkKIixNAbaEJkDBGCkeI98URQz10qiYcIzD",
            "me/mioclient/m$$EkBZpVHAhScnNYMQsB7Fl9cvH8DC0HGbrjZnUm9sh1KEKWJ8DH4iSikX6UCmt1NmA6PPK0lfTBut0IJg2080VVoKa0yyITsHb",
            "me/mioclient/m$$zInWTtSa2bcxkI9dKIYgG2eLrMIx8esF3IhJjEkwk0KMRi9N8jsbGugqexM46WVzt7D9664JQldREKJs6fuhCK8YsnOxIhZ2P",
            "me/mioclient/m$$r50RXd3eMY7TtIHdfDICPzAK4P5n0DTCoEjwQJM1raL4BuRn83AbehPLT3v8arKKCOUpgy9qba53IwZyUjD7kh1a66SjHCzHU",
            "me/mioclient/m$$ekSKcKfPPrOh3kUvgEGY5JGS530EVStxyKKQqL2Yudp0nH6b8LelDQpd9L5ChpUsVT5uq58CvevYbrwtfU9iHczZQ39JiVEyU",
            "me/mioclient/m$$7Zag8IN4ynLAhlHB9CCWoKBIL6jUUPs48Fk6hjUmopxPc5UtlXjTRz9mLNyGYmNknCdZMOWtLSWY5p6cKXhXDNvSIQ5hLDzit",
            "me/mioclient/m$$gIWuhopFlzYn3lLaNwc6liBuHp5CSvxlhrPEi2lchjuDkEfzjQQJ0EiFZ98i0vrnLbl3KQ3dDTDAMkwQ0fumK2RgSxdXVrEt2",
            "me/mioclient/m$$vs92k3WxGbVszr8PIA5vUZCFONLGriMHOkbPpKCIx6HIJaCckDOnkVEMO1IsT2RDIblgik2uIq9LV2w7mOQYVJCNNzltM08TF",
            "me/mioclient/m$$XVScMX2tfeTkxiErLHWvKGxaxqeXdksq4hQGK6vz9E4yPiLH3UlhjeBi83iLm4Qon2XNCzEETa5gxZ36ELj2DMjvam19T9JNo",
            "me/mioclient/m$$wSdmr54S7RzOQ0NlSRAf0tp09zeB3AmyieU9JbOwALOKhZjIytTyOz6oXsurOKBaa5QieMelSbnoyPAoqnhPC09cuaknU0v3Q",
            "me/mioclient/m$$XTuXCvyYozB0kE937eJMlF7ywcMl2q8KnJtxsMRRCFPeZWVA1W9zwPi94YADhMSqoZnHFN82OZZzNqs65voFa8TB8YAwnIc3s",
            "me/mioclient/m$$OOPjmXDJfUSlAFZwiAYNJ7y4qe5KIYLAQcFe2enCgSI5uKyt7Dbw9pV2ZGTpDiqROZ6mc3w3bNZxanOSLyWZiT4rkP4N053ga",
            "me/mioclient/m$$w9mPKIH6gi4hsJWTpsWqe3zmXpcVwJa89kYKzRMBH0drlkQvkScHLj2PrdU4SPQkl7VSrzI963x82T4w79WthWZvA4Zxhbbw8",
            "me/mioclient/m$$E4cmtVXqR1DtTocNnfZpgVeEaMeNb07tJgwX5ulo11W1h6Z5KWsEn1m0YpuaZQCCJHfD44qZBOl20BAydHn3jvjpYQZdTTncb",
            "me/mioclient/m$$GQz6SdjDqPJ2IOXEB1B0DxaPmuy2PY7iIqmJj9pOeR03721l458W7RfjQScQqE56p7ZSM5knWzC8mjK9V2H196vJ0YFsTFEjj",
            "me/mioclient/m$$MF7va80XKizqudUZHZKALvMsD5z2EoIu7IFbx79KvKdjKUTmm0tlp5FrxjueDpIWHZepolTYjamZZrFN2JrBKJWuNB0Nr7lss",
            "me/mioclient/m$$8oSuMhfAlxPGVima8hDStUYsCSwRJ9G9w5cGqo3t5sP1vda0pnAMfzMoUJDinsN2nfcFqw9fwQxpr7lbC759yhJybwW3n2iI4",
            "me/mioclient/m$$wt0aVyiY9pWH1L8RVKJ4hSnYEGW6s7exMm4Y7wT65Hs3U13i42iXYggdnt3qsPA6jns9jNODw018zZN1b7E49Gs0XGKhKUySK",
            "me/mioclient/m$$PxLqdZGrhCDC12QcuzU5tGFNs09La3nrp5UyYPxmHnLvAqgnSb06EbQM8Am1wJNfCZcyhpUXI8vs2pTakWUEoJGmiqHibPeFj",
            "me/mioclient/m$$XXAQjHGiADlTlXCQUwAdKUP44hxs3UwxAj6F3QG8x4qhnN7BgJNukp4cpfd5e3RJ0xBfYMsgdWrZy2a0ZGx2PRF5KtK6lcaqp",
            "me/mioclient/m$$rSh293VlEHs9woEyNEkUh04ulw9CzBYkjx4UCk32WJCrB5Sb8ncsZiizsU8khga1Ui88ksRgvpiB3jNfBvCiaHWw47zksVy17"
    );

    public static void initialize(Object manager) {
        try {
            Class<?> k = manager.getClass();
            Method m = k.getDeclaredMethod(
                    "m$$91y4uxO1IQagfYqm9FEgYw5vvDkJrRONLQWZCs7n9wzW9fgwgnegqCayTRnSmFjflHrBYGF6ZLPzDKu4mbNi5nwosBbhplPea",
                    Class.forName("me.mioclient.m$$w9RkV5gTt6ZndK3Uzxqy3DHcO6lwV7MMjmIAH1ZpwaB4GXfxd4yO63rqeR3DHTfzUXq15nxgT4P8aW7zWibHeFQLetK4BIdta")
            );

            for (String module : MODULES) {
                Class<?> klass = Class.forName(module.replace('/', '.'));
                Constructor<?> c = klass.getDeclaredConstructor();
                m.invoke(manager, Objects.requireNonNull(c).newInstance());
            }
        } catch (Throwable _t) {
            _t.printStackTrace(System.err);
        }
    }

    private static final List<String> EXTRA = List.of(
            "me/mioclient/m$$H9n4ak8lb4y3DNw6DlYJyEGXWIE21pAOTpOCjfxzhWY3iTmkhnL5BCQrSYL3IG7UwC7tUsEHC5UCBZ8JV0FdMQnFF684SISkP"
    );

    public static void extra(Object manager) {
        try {
            Class<?> k = manager.getClass();
            Method m = k.getDeclaredMethod(
                    "m$$91y4uxO1IQagfYqm9FEgYw5vvDkJrRONLQWZCs7n9wzW9fgwgnegqCayTRnSmFjflHrBYGF6ZLPzDKu4mbNi5nwosBbhplPea",
                    Class.forName("me.mioclient.m$$w9RkV5gTt6ZndK3Uzxqy3DHcO6lwV7MMjmIAH1ZpwaB4GXfxd4yO63rqeR3DHTfzUXq15nxgT4P8aW7zWibHeFQLetK4BIdta")
            );

            for (String module : EXTRA) {
                Class<?> klass = Class.forName(module.replace('/', '.'));
                Constructor<?> c = klass.getDeclaredConstructor();
                m.invoke(manager, Objects.requireNonNull(c).newInstance());
            }
        } catch (Throwable _t) {
            _t.printStackTrace(System.err);
        }
    }
}
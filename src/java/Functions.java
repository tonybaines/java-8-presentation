/*============================================================================*
 * - COPYRIGHT NOTICE -
 *
 * Copyright (c) British Telecommunications plc, 2010, All Rights Reserved
 *
 * The information contained herein and which follows is proprietary
 * information and is the property of BT. This information is not to be
 * divulged, released, copied, reproduced, or conveyed to unauthorised
 * personnel,companies or other institutions without the direct and expressed
 * approval in writing of BT
 *
 *============================================================================*/

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Functions {
  static final Function<String, Integer> answer = (s) -> s.length();

  public static void main(String[] args) {
    assert answer.apply("foo") == 3;

    IntPredicate intPredicate = new IntPredicate() {
      @Override
      public boolean test(int i) {
        return i % 2 == 0;
      }
    };
    IntStream.rangeClosed(0,10)
      .filter(intPredicate)
      .reduce(Integer::sum);


    Optional<String> foo = Optional.of("foo");

    Period periodOfTenDays = Period.ofDays(10);// Amount of time measured in years/months/days
    Duration durationOfTenDays = Duration.of(10, ChronoUnit.DAYS);// Amount of time recorded to the nanosecond;
    Instant now = Instant.now();// Specific point in time

    Instant tenDaysFromNow = now.plus(durationOfTenDays);

    LocalTime.parse("10:15:30");

    new java.sql.Date(1234567879).toLocalDate();
    new java.sql.Timestamp(1234567879).toInstant();

    java.sql.Date.from(Instant.now());
    java.sql.Timestamp.from(Instant.ofEpochMilli(1234567879));

    java.util.Date.from(Instant.now());

    new java.util.Date().toInstant();
  }
}

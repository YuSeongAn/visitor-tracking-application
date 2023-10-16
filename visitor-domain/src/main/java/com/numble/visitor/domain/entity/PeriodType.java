package com.numble.visitor.domain.entity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

public enum PeriodType {
    ALL {
        @Override
        public LocalDateTime calculateStandardDateTime(LocalDateTime timestamp) {
            return null;
        }
    },
    DAILY {
        @Override
        public LocalDateTime calculateStandardDateTime(LocalDateTime timestamp) {
            return LocalDateTime.of(timestamp.toLocalDate(), LocalTime.MIN);
        }
    },
    WEEKLY {
        @Override
        public LocalDateTime calculateStandardDateTime(LocalDateTime timestamp) {
            final LocalDate currentWeekMonday = timestamp.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).toLocalDate();

            return LocalDateTime.of(currentWeekMonday, LocalTime.MIN);
        }
    };

    public abstract LocalDateTime calculateStandardDateTime(LocalDateTime timestamp);
}

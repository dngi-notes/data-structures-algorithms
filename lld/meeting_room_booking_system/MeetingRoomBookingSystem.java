package lld.meeting_room_booking_system;

import java.util.*;

/**
 * Design a Meeting Room Booking System
 * You are asked to design a system that manages meeting rooms in an office
 * building.
 * 
 * Requirements:
 * - The office has multiple floors
 * - Each floor has multiple meeting rooms
 * - Each meeting room:
 * - Has a capacity
 * - Has a unique room ID
 * - Meetings:
 * - Have a start time and end time
 * - Are booked for one room only
 * - Rules:
 * - A room cannot be double-booked
 * - A meeting must fully fit within the requested time range
 * - The system should support:
 * - bookRoom(meetingRequest)
 * - cancelMeeting(meetingId)
 * - findAvailableRooms(timeRange, minCapacity)
 */
public class MeetingRoomBookingSystem {
    /**
     * OfficeFloor
     * - rooms: List<MeetingRoom>
     * - bookRoom(meetingRequest)
     * - cancelMeeting(meetingId)
     * - findAvailableRooms(timeRange, minCapacity)
     * 
     * MeetingRoom
     * - capacity: int
     * - roomId: string - (unique)
     * NOTE: room cannot be double booked
     * 
     * Meeting
     * - TimeRange: Object
     * 
     * TimeRange
     * - start: int
     * - end: int
     * NOTE: meeting can only be booked for one room only
     * NOTE: meeting should fit into the time range requested fully
     */
    class MeetingRoom {
        int capacity;
        long roomId;
        List<Meeting> meetings;

        boolean canBook(TimeRange range) {
            for (Meeting m : meetings) {
                if (m.getTimeRange().overlaps(range)) {
                    return false;
                }
            }

            return true;
        }

        void book(Meeting meeting) {
            meetings.add(meeting);
        }

        boolean remove(Meeting meeting) {
            if (meetings.contains(meeting)) {
                meetings.remove(meeting);
                return true;
            }

            return false;
        }
    }

    class Meeting {
        TimeRange timeRange;

        public Meeting(TimeRange timeRange) {
            this.timeRange = timeRange;
        }

        public TimeRange getTimeRange() {
            return timeRange;
        }
    }

    class TimeRange {
        int start;
        int end;

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public boolean overlaps(TimeRange range) {
            return (this.start < range.end && range.start < this.end);
        }
    }

    class OfficeFloor {
        List<MeetingRoom> rooms;
        Map<Meeting, MeetingRoom> meetingToRoom;

        Optional<MeetingRoom> findAvailableRoom(TimeRange range, int minCapacity) {
            for (MeetingRoom room : rooms) {
                if (room.capacity >= minCapacity && room.canBook(range)) {
                    return Optional.of(room);
                }
            }
            return Optional.empty();
        }

        boolean bookRoom(TimeRange range, int minCapacity) {
            Optional<MeetingRoom> availableRoomOpt = findAvailableRoom(range, minCapacity);

            if (availableRoomOpt.isPresent()) {
                MeetingRoom roomToBook = availableRoomOpt.get();
                Meeting newMeeting = new Meeting(range);
                roomToBook.book(newMeeting);
                meetingToRoom.put(newMeeting, roomToBook);
                return true;
            }

            return false;
        }

        boolean cancelMeeting(Meeting meeting) {
           MeetingRoom room = meetingToRoom.get(meeting);
           return room.remove(meeting);
        }
    }
}
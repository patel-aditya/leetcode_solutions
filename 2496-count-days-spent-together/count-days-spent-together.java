class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int aliceArriveMonth = Integer.parseInt(arriveAlice.substring(0, 2));
        int bobArriveMonth = Integer.parseInt(arriveBob.substring(0, 2));
        int aliceLeaveMonth = Integer.parseInt(leaveAlice.substring(0, 2));
        int bobLeaveMonth = Integer.parseInt(leaveBob.substring(0, 2));

        int aADay = Integer.parseInt(arriveAlice.substring(3, 5));
        int bADay = Integer.parseInt(arriveBob.substring(3, 5));
        int aLDay = Integer.parseInt(leaveAlice.substring(3, 5));
        int bLDay = Integer.parseInt(leaveBob.substring(3, 5));

        int start = Math.max(bobArriveMonth, aliceArriveMonth);
        int end = Math.min(bobLeaveMonth, aliceLeaveMonth);

        if (aliceLeaveMonth < bobArriveMonth || bobLeaveMonth < aliceArriveMonth)
            return 0;

        if(aliceArriveMonth == bobLeaveMonth){
            if(aADay > bLDay) return 0;
        }
        if(bobArriveMonth == aliceLeaveMonth){
            if(bADay > aLDay) return 0;
        }

        if(start == end){

            if(aADay == bLDay || aLDay == bADay) return 1;
            
            if(bobArriveMonth == bobLeaveMonth && bADay > aADay && end != aliceLeaveMonth) return bLDay + 1 - bADay;

            if(aliceArriveMonth == start && bobLeaveMonth == start && (aliceArriveMonth != aliceLeaveMonth || bobArriveMonth != bobLeaveMonth)){
                if(bLDay > aADay) return bLDay+1 - aADay;
            }
        }

        int res = 0;
        for (int i = start; i <= end; i++) {
            if (i == end) {
                if (end == aliceLeaveMonth && end == bobLeaveMonth) {
                    if (aliceArriveMonth == bobArriveMonth && start == end) {
                        res += Math.min(aLDay + 1, bLDay + 1) - Math.max(aADay, bADay);
                    }
                    else if (aliceArriveMonth > bobArriveMonth && aliceArriveMonth == end) {
                        res += Math.min(aLDay + 1, bLDay + 1) - aADay;
                    } else if (bobArriveMonth > aliceArriveMonth && bobArriveMonth == end) {
                        res += Math.min(aLDay + 1, bLDay + 1) - bADay;
                    } else {
                        res += Math.min(aLDay, bLDay);
                    }
                } else if (end == aliceLeaveMonth) {
                    res += aLDay;
                } else if (end == bobLeaveMonth) {
                    res += bLDay;
                }
            } else {
                if (i == aliceArriveMonth && i == bobArriveMonth) {
                    res += (months[i - 1] + 1 - Math.max(aADay, bADay));
                } else if (i == aliceArriveMonth) {
                    res += months[i - 1] + 1 - aADay;
                } else if (i == bobArriveMonth) {
                    res += months[i - 1] + 1 - bADay;
                } else {
                    res += months[i - 1];
                }
            }
        }

        return res;
    }
}
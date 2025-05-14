class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int current = parseTime(pos);
        int start = parseTime(op_start);
        int end = parseTime(op_end);
        int max = parseTime(video_len);

        for(int i = 0; i < commands.length; i++) {
        
            if (current >= start && current <= end) {  current = end;  }
            
            if (commands[i].equals("next")) {   current = Math.min(current + 10, max);  } 
            else if (commands[i].equals("prev")) {    current = Math.max(current - 10, 0);  }
            
            if (current >= start && current <= end) {   current = end;  }
        }
        answer = formatTime(current);
        return answer;
    }
    
    private static int parseTime(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
    private static String formatTime(int time) {
        int minutes = time / 60;
        int seconds = time % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
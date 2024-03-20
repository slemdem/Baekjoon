class Solution {
    private int[] move(int[] position, char op){
        switch(op){
            case 'N':
                position[0] -= 1;
                break;
            case 'S':
                position[0] += 1;
                break;
            case 'W':
                position[1] -= 1;
                break;
            case 'E':
                position[1] += 1;
                break;
        }
        return position;  
    }

    private int[] cancle(int[] position, char op){
        switch(op){
            case 'N':
                position[0] += 1;
                break;
            case 'S':
                position[0] -= 1;
                break;
            case 'W':
                position[1] += 1;
                break;
            case 'E':
                position[1] -= 1;
                break;
        }
        return position;  
    }

    public int[] solution(String[] park, String[] routes) {
        int parkWidth = park[0].length();
        int parkHight = park.length;
        char[][] parkChar = new char[parkHight][parkWidth];
        int[] answer = new int[2];
        char op;
        int n;

        for(int i=0; i<parkHight; i++){
            for(int j=0; j<parkWidth; j++){
                parkChar[i][j] = park[i].charAt(j);
                if (parkChar[i][j] == 'S'){
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        for(int i=0; i<routes.length; i++){
            op = routes[i].charAt(0);
            n = Integer.parseInt(routes[i].substring(2));
            for(int j=0; j<n;j++){
                answer = move(answer,op);
                if(answer[0] < 0 || answer[0] >= parkHight || answer[1] < 0 ||
                   answer[1] >= parkWidth||parkChar[answer[0]][answer[1]] == 'X'){
                    for(int k = 0; k <= j; k++){
                            answer = cancle(answer,op);
                    }
                    break;
                }
            }
        }
        return answer;
    }

}
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        // idx의 범위는 1<=idx<=n
        int idx = 1; 
        // stIdx의 최댓값은 stations.length-1
        int stIdx = 0; 
        // 조건문 처리를 위해 stations의 마지막 값에 절대 도달 못하는 값을 넣음
        int[] temp = new int[stations.length+1]; 
        // temp를 station의 깊은 복사
        for(int i=0;i<stations.length;i++)
        {
            temp[i] = stations[i];
        }
        // 도달 못하는 값으로 설정
        temp[stations.length] = 200000001 + w;
        // 새롭게 stations 배열 할당
        stations = new int[temp.length];
        // 깊은 복사로 stations에 temp를 복사
        for(int i=0;i<stations.length;i++)
        {
            stations[i] = temp[i];
        }
        // idx가 n이 될 때까지 기지국 설치
        while(idx <= n){
            // 기지국 바운더리 안에 없으면
            if(idx<stations[stIdx]-w){
                // 마지막 stIdx는 끝을 의미
                if(stIdx == stations.length){
                    break;
                }
                answer++;
                idx = idx+2*w+1; // 새로 설치한 기지국의 바운더리까지 이동
            }
            // 기지국 바운더리 안에 있으면
            else if(idx>=stations[stIdx]-w && idx<=stations[stIdx] + w){
                idx = stations[stIdx] + w + 1; // 해당 기지국 바운더리까지 이동   
            } 
            // 기지국보다 더 앞에 있으면 stIdx 증가
            else{
                stIdx++;
            }
        }
        return answer;
    }
}

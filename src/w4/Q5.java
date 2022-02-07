package w4;

public class Q5 {
    public static void main(String[] args) {
        // 가로세로로 접해있는 경우에만 인접한 문명이라고 한다.
        // 한 해가 지날 때마다 사면에 인접한 지역에 문명을 전파한다.
        // 이번 해에 문명이 전파된 후 미개지역에 다 인접해있다면 그 문명은 하나로 결합된다. (다음해까지 가지 않음)
        // while을 돌면서 year를 세야 한다.
        // 이차원 배열 : 초기값은 0,0 (크기 중요하지 않음) -> 크기 관리해야 한다.
        // find : 그냥 루트의 좌표를 리턴하면 된다. <- 좌표를 리턴하려면 이차원 배열이 그냥 배열이 아니라 point의 배열이어야겠네
        // union : 하던대로 합치면 된다.
        // while 돌면서 +-1 위치에 있는 걸 검사, union 한다.
        // union 한 후에 모든 문명이 하나로 결합되는지 검사해야 하는데...
        // 배열 아니고 해시맵으로 간다 key가 좌표이고 value가 부모노드를 가리키는 것!!
        // 이렇게 되면 모든 문명이 하나로 결합되는지 검사할 때 value가 0인 key의 상하좌우 value가 0인지 아닌지 보면 된다.
        // 상하좌우 하나라도 0이면 합쳐지지 않으니까 year+1 한다.
        // 근데 value로 찾으려면 키셋을 반복 돌아야 하는데 어떡하지?
    }
}

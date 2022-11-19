package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<Direction> bridge;
    private List<Direction> history = new ArrayList<>();
    private boolean giveUp = false;

    public BridgeGame() {
    }

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge.stream()
                .map(Direction::fromSymbol)
                .collect(Collectors.toList());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Direction direction) {
        history.add(direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge.stream()
                .map(Direction::fromSymbol)
                .collect(Collectors.toList());
    }

    public boolean isSuccess() {
        return history.size() == bridge.size();
    }



    public void getCurrentState(){

    }

    public boolean isFail() {
        int currentIdx = history.size()-1;
        return !history.get(currentIdx).equals(bridge.get(currentIdx));
    }

    public boolean isEnd() {
        return giveUp || isSuccess();
    }

    public void setGiveUp(boolean b) {
        this.giveUp = b;
    }
}
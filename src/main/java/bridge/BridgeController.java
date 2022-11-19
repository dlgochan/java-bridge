package bridge;

import java.util.List;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;

    public BridgeController() {
        this.inputView =  new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }


    public void run() {
        begin();
        initGame();
        play();
        end();
    }

    private void begin() {
        outputView.printBegin();
    }

    private void initGame() {
        OutputView.askSize();
        int size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);
        bridgeGame.setBridge(bridge);
    }

    private void play() {
        while(!bridgeGame.isEnd()){
            move();
            if(bridgeGame.isFail()){
                askRetry();
            }
        }
    }

    private void askRetry() {

    }


    private void move() {
        outputView.askDirection();
        Direction direction = inputView.readMoving();
        bridgeGame.move(direction);
    }

    private void end() {
        outputView.printResult();
    }
}

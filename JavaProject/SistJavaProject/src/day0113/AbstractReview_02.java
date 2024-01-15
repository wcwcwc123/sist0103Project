package day0113;

abstract class Game{
    abstract public void play();
    abstract public void stop();
}

class Kim extends Game{

    @Override
    public void play() {
        System.out.println("kim 게임시작");

    }

    @Override
    public void stop() {
        System.out.println("kim 게임 중지");

    }
}
class Lee extends Game{

    @Override
    public void play() {
        System.out.println("Lee 게임시작");

    }

    @Override
    public void stop() {
        System.out.println("Lee 게임 중지");

    }
}
class Choi extends Game{

    @Override
    public void play() {
        System.out.println("Choi 게임시작");

    }

    @Override
    public void stop() {
        System.out.println("Choi 게임 중지");

    }
}

public class AbstractReview_02 {
    public static void main(String[] args) {
//        Game game = null;
//
//        game = new Kim();
//        game.play();
//        game.stop();
//
//        game = new Lee();
//        game.play();
//        game.stop();
//
//        game = new Choi();
//        game.play();
//        game.stop();

        Game[] game2 = new Game[3];

        game2[0] = new Kim();
        game2[1] = new Lee();
        game2[2] = new Choi();

        for (int i = 0; i < game2.length; i++) {
            game2[i].play();
        }

        System.out.println("==============");
        for (int i = game2.length - 1; i >= 0; i--) {
            game2[i].stop();
        }
    }



}

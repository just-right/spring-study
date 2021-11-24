package dynamicProxy.entity;

/**
 * @author luffy
 * @date 2021/11/24
 * 玩家
 */
public class Player {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

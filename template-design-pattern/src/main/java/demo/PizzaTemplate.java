package demo;

public abstract class PizzaTemplate {

    public final void sellPizza(){
        prepared();
        topping();
        bake();
        serve();
        checkBill();
    }
    //------------------------------------
    public abstract void prepared();
    public abstract void topping();
    public abstract void bake();
    public abstract void serve();
    public abstract void checkBill();
}

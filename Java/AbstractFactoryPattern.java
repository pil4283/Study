public class AbstractFactoryPattern{
    public static void main(String[] args) {
        String os = System.getProperty("os.name");
        System.out.println(os);
    }
}

interface IButton{
    void Paint();
}

interface IGUIFactory{
    IButton CreateButton();
}

class WinFactory implements IGUIFactory{
    public IButton CreateButton(){
        return new WinButton();
    }
}

class OSXFactory implements IGUIFactory{
    public IButton CreateButton(){
        return new OSXButton();
    }
}

class WinButton implements IButton{
    public void Paint(){

    }
}

class OSXButton implements IButton{
    public void Paint(){

    }
}
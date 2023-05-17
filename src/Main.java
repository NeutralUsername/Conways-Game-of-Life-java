
public class Main {
    public static void main(String[] args) throws InterruptedException {
       World world = new World(10, 10);
       world.generateGlider(0,0);
       while (true) {
         System.out.println(world.toString());
         world.nextGeneration();
         Thread.sleep(500);
       }
    }
}
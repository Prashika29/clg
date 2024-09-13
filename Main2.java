import java.util.ArrayList;
class ChicagoPizzaStore extends PizzaStore
{
Pizza createPizza(String item)
{
if(item.equals("cheese"))
{
return new ChicagoStyleCheesePizza();
}
else return null;
}
}
class ChicagoStyleCheesePizza extends Pizza
{
public ChicagoStyleCheesePizza()
{
name="Chicago style deeep dish cheese pizza";
dough="Extra thick  crust dough";
sauce="plum tomato sauce";
toppings.add("SHreadded Mozarrale cheese");
}
void cut()
{
System.out.println("Cutting the pizza into sqaure slices");
}
}
class DependentPizzaStore
{
public Pizza createPizza(String style, String type)
{
Pizza pizza=null;
if(style.equals("NY"))
{
if(type.equals("cheese"))
{
pizza=new NYStyleCheesePizza();
}
}
if(type.equals("Chicago"))
{
if(type.equals("cheese"))
{
pizza = new ChicagoStyleCheesePizza();
}
}
else
{
System.out.println("Error: invalid type of pizza");
}
pizza.prepare();
pizza.bake();
pizza.cut();
pizza.box();
return pizza;
}
// return null;
}
class NYPizzaStore extends PizzaStore
{
Pizza createPizza(String item)
{
if(item.equals("cheese"))
{
return new NYStyleCheesePizza();
}
else return null;
}
}
class NYStyleCheesePizza extends Pizza
{
public NYStyleCheesePizza()
{
name="NY style sauce and cheese pizza";
dough="thin crust dough";
sauce="Marinara sauce";
toppings.add("grated reggiano cheese");
}
}
abstract class Pizza
{
String name;
String dough;
String sauce;
ArrayList toppings= new ArrayList();
void prepare()
{
System.out.println("Preparing " + name);
System.out.println("Tossing dough...");
System.out.println("Adding sauce...");
System.out.println("Adding toppings: ");
for(int i=0;i<toppings.size();i++)
{
System.out.println(" "+toppings.get(i));
}
}
void bake()
{
System.out.println("Bake for 25 minutes at 350");
}
void cut()
{
System.out.println("Cutting the pizza into diagonal slices");
}
void box()
{
System.out.println("Place pizza in official PizzaStore box");
}
public String getName()
{
return name;
}
public String toString()
{
StringBuffer display = new StringBuffer();
display.append("---" + name + "---\n");
display.append(dough + "\n");
display.append(sauce + "\n");
for(int i=0;i<toppings.size();i++)
{
display.append((String)toppings.get(i) + "\n");
}
return display.toString();
}
}
abstract class PizzaStore
{
abstract Pizza createPizza(String item);
public Pizza orederPizza(String type)
{
Pizza pizza = createPizza(type);
System.out.println("---Making a " + pizza.getName() + "---");
pizza.prepare();
pizza.bake();
pizza.cut();
pizza.box();
return pizza;
}
}
public class Main2
{
public static void main(String args[])
{
PizzaStore nyStore = new NYPizzaStore();
PizzaStore chicagoStore = new ChicagoPizzaStore();
Pizza pizza = nyStore.orederPizza("cheese");
System.out.println("Sumit ordered a "+pizza.getName()+"\n");
pizza=chicagoStore.orederPizza("cheese");
System.out.println("Sakshi ordered a "+pizza.getName()+"\n");
pizza=nyStore.orederPizza("cheese");

}
}

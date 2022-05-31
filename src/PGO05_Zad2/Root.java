package PGO05_Zad2;

 class Root extends Plant{

     Root(String name, int baseReagent, int power) {
         super(name, baseReagent, power);
     }

     @Override
     int getReagent() {
         return super.getReagent() / 2;
     }
 }

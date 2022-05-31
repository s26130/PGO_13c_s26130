package PGO05_Zad2;

 class Ore extends Mineral {
     private boolean metallic;

     Ore(String name, int baseReagent, int power, boolean metallic) {
         super(name, baseReagent, power);

         this.metallic = metallic;
     }

     @Override
     int getReagent() {
         if(!metallic){
             return super.getReagent() / 2;
         } else {
             return super.getReagent();
         }
     }
 }

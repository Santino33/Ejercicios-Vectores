package Controler;

import Model.Room;
import View.IoManager;

import java.util.Arrays;

public class Control {
    Room room = new Room();
    IoManager ioManager = new IoManager();
    public void init(){
        ioManager.showMessage(""+ Arrays.toString(room.arrayDiff(new int[]{4, -6, 6, 6, 7, 8, 9}, new int[]{6, 7})));

        ioManager.showMessage("Los numeros mayor y menor del array son: "+ room.highestAndLowestArray(new int[] {-5, -6, 7, 10, 3}));

        ioManager.showMessage("Los n numeros mayores del array dado son: "+Arrays.toString(room.larguestNumbers(3, new int[]{-4, 65, -7, -3, -80, -1})));
    }
}

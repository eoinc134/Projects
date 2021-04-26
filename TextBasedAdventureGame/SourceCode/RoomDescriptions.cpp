#include "RoomDescriptions.h"

string RoomDescriptions::getDescription(string roomName){
    string str = " Could not find description";
    if(roomName.compare("start") == 0){
        str= " You wake up and are standing in an open field \n"
             " To your north there is a house \n"
             " To your south you see a cross roads";

    } else if(roomName.compare("house") == 0){
        str= " You enter the house \n"
             " Out the front door to the south you see an open field \n"
             " Out the back there is a small meadow to the north \n"
             " To your east there is a bedroom, to your north is the kitchen";

    } else if(roomName.compare("kitchen") == 0){
        str= " You enter the kitchen \n"
             " There is a living room to the east";

    } else if(roomName.compare("bedroom") == 0){
        str= " You enter the bedroom \n"
         " There is the living room to the north";

    } else if(roomName.compare("livingRoom") == 0){
        str= " You enter the livingRoom \n"
             " You see a meadow outisde to the north \n"
             " To the west there is a kithcen ";

    } else if(roomName.compare("meadow") == 0){
        str= " You are in a meadow \n"
             " You take a rest \n"
             " You can leave through the house to the south \n"
             " Or enter the forest to the west";

    } else if(roomName.compare("crossroads") == 0){
        str= " You enter the crossroads \n"
             " You see a glittering path to the west \n"
             " You see a well travelled path to the south \n"
             " You see an onimous looking path to the east";

    } else if(roomName.compare("westPath") == 0){
        str= " You enter the westPath\n"
             " You see a shiny chest to the east and wonder if it could be a trap?\n"
             " You can return to the crossroads to the east";

    } else if(roomName.compare("treasureTrove") == 0){
        str= " You enter the treasureTrove, with a chest overflowing with gold, HUZZAH! \n"
             " You may exit to the path in the west";

    } else if(roomName.compare("eastPath") == 0){
        str= " You enter the eastPath \n"
             " You see the path continue in the east to what looks like the opening of a cave \n"
             " Or you may exit to the cross roads in the west";

    } else if(roomName.compare("caveEntrance") == 0){
        str= " The light from the sun is beginning to fade, perhaps theres an item you should use? \n"
             " Inside the cave you see a path descending down to the North \n"
             " You may return to the path in which you came from to the east, this path will surely bring safety ";

    } else if(roomName.compare("cave1") == 0){
        str= " You have traversed deeper into the cave \n"
             " There is a path up high to the north, you cannot reach it from here\n"
             " You may travel back to the east towards the entrance of the cave";

    } else if(roomName.compare("cave2") == 0){
        str= " You have entered into the cave. \n"
             " To the west there is a path that leads deeper into the cave\n"
             " There is a similar path to the east that also leads deeper into the cave" ;

    } else if(roomName.compare("cave3") == 0){
        str= " You have travelled the west path of the cave \n"
             " To the north you see piles of skulls and bones, danger certainly lies ahead \n"
             " You see a rope bridge to the north, it doesnt look safe and could collapse at any moment, you can risk crossing it or \n"
             " You may retreat from where you came to the east";

    } else if(roomName.compare("cave4") == 0){
        str= " You are standing on the rope bridge \n"
             " It doesn't fell very safe \n"
             " You may go south and follow the path back towards the cave entrance ";

    } else if(roomName.compare("cave5") == 0){
        str= " You are now the on the other side of that deathrap of a bridge \n"
             " You may follow the path to the east or\n"
             " You may cross the rope bridge to the south, it doesnt look safe and could collapse at any moment";

    } else if(roomName.compare("cave6") == 0){
        str= " You have entered a clearing in the cave, you have successfully explored deep into the cave \n"
             " There is a suspicious room with leaves covering the ground to the east, quite an unusual discovery in a cave ";

    } else if(roomName.compare("cave7") == 0){
        str= " CRASH!!! \n"
             " The floor beneath you collapses. It was a trap!\n"
             " You have lost 50% of your health, luckily ropes appear to have also fallen\n"
             " To the south there is piles of skulls and bones or \n"
             " To the west appears to be safe spot";

    } else if(roomName.compare("cave8") == 0){
        str= " You reach a small open area in the cave, you are surrounding by piles of skulls and bones, \n"
             " You have stumbled upon someones home and from above drops a pile of webs. You look inside and theres a body";

    } else if(roomName.compare("cave9") == 0){
        str= " There is a chest in the centre and it looks like it is holding something important, perhaps its worth searching\n"
             " You may exit to the east to the piles of skulls and bones";

    } else if(roomName.compare("southPath") == 0){
        str= " You are on the path south of the cross roads\n"
             " You can travel north back to the cross roads\n"
             " There is also a path to the east leading to a path heading into the mountains or\n"
             " You could travel west to a small clearing, \n the ground is covered in black ash and the surrounding trees are burnt, \n perhaps its a sign of an enemy";

    } else if(roomName.compare("finalBoss") == 0){
//if (dragon == alive)
        str= " You feel the ground around you start to rumble as you hear a roar from the distance approaching rapidly \n"
             " A dragon flies into the clearing breathing fire as it comes. \n"
             " It sets the ground surrounding you on fire blocking any hope of escape";
//if dragon == dead	first time
/*			 " You stare at the corpse of the dragon glad the fight is over.\n"
             " You watch as the flames die down and look at what is around you \n"
             " There is an exit further ahead to the west, it looks like you might finally be able to escape this place or\n"
             " You can turn back and head back to the path south of the cross roads"

*/
    } else if(roomName.compare("bridge") == 0){
        str= " You have reached a bridge leading west out of this world, alas it stands behind a lock\n"
             " Do you have a key to open the door? Try using it?\n"
             " The only other exit appears to be return east where you came from";

    } else if(roomName.compare("forestPath") == 0){
        str= " You follow the small path through the forest\n"
             " The path continues to the exit in the east \n"
             " You may also head deeper into the forest either north, south or west";

    } else if(roomName.compare("forest1") == 0){
        str= " You have entered into the Forest, there doesnt appear to be much useful things here \n"
             " You could go north back onto the path or \n"
             " Go west deeper into the forest";

    } else if(roomName.compare("forest2") == 0){
        str= " You have entered deep into the forest and take note of the beautiful trees towering above you \n"
             " There doesnt seem to be much of use here but sometimes admiring the view is worth it \n"
             " You may exit north and see where the path leads to or \n"
             " You may exit to the east into the forest and admire some more trees";

    } else if(roomName.compare("forest3") == 0){
        str= " You have stumbled upon a dwarf sitting silently on a rock\n"
             " You may exit to the north into a clearing, \n"
             " Exit to the south deeper into the forest or \n"
             " You may go back onto the path to exit the forest";

    } else if(roomName.compare("forest4") == 0){
        str= " You have entered the clearing of the forest, you see a sword embedded into the rock\n"
             " It looks like it is stuck\n"
             " You may exit to the south where the forest path leads or\n"
             " You may exit to the east into the forest";

    } else if(roomName.compare("forest5") == 0){
        str= " You are surrounded by trees \n"
             " You may exit to the west into a clearing in the forest \n"
             " The south leads back onto the forest path or \n"
             " You may head to a meadow in the east. \n"
             " It looks like a good place to take a rest and relax";

    } else if(roomName.compare("mountainPath") == 0){
        str= " You have entered the path leading to the mountains \n"
             " You may return back onto the path from which you came to the west or \n"
             " you may follow the path leading deeper into the mountains";

    } else if(roomName.compare("mountain1") == 0){
        str= " You begin your hike into the mountains, it is tough going. \n"
             " You almost lose your footing but manage to catch yourself before you fall \n"
             " You look around and see a path leading to the east \n"
             " Or you may return to the base of the mountains by the path to the west";

    } else if(roomName.compare("mountain2") == 0){
        str= " You are struck by a disgusting smell, you look around and find a goblin on the floor, his carcass being picked at by the hawks above\n"
             " The goblin must of either fell or starved to his death, you debate with yourself if its worth searching the body to see if he carried anything valuable \n"
             " You look around and see the path leads to the north towards the summit of the mountain or \n"
             " You may return back towards the base of the mountain in the west";

    } else if(roomName.compare("mountain3") == 0){
        str= " You are at the summit of the mountain. You look around and admire the beautiful view. \n"
             " You discover you are on an island trapped by the waters flowing around you.\n"
             " You spot a bridge towards the south east of the map\n"
             " You're only exit is to return the way you came by going south";

    } else if(roomName.compare("exit") == 0){
        str= " HUZZAH YOU HAVE ESCAPED THE ISLAND AND HAVE COMPLETED THE GAME";

    }

    return str;
}


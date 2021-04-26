#include "Item.h"

Item::Item(const Item &item){
    this->name = item.name;
    this->description = item.description;
    this->value = item.value;
    this->weight = item.weight;
    this->weapon = item.weapon;
    this->edible = item.edible;
}

Item::Item(string name, string description, int value, int weight, bool weapon, bool edible){
    this->name = name;
    this->description = description;
    this->value = value;
    this->weight = weight;
    this->weapon = weapon;
    this->edible = edible;
}

string Item::getItem(){
    return this->name;
}
int Item::getValue(){
    return this->value;
}
void Item::setValue(int value){
    this->value = value;
}
int Item::getWeight(){
    return this->weight;
}
bool Item::isWeapon(){
    return this->weapon;
}
bool Item::isEdible(){
    return this->edible;
}

string Item::examineItem(){
    string itemOut;
    itemOut +=  " Item:\t"  + this->name + "\n";
    itemOut +=  " Description: \t"  + this->description + "\n";
    itemOut +=  " Value:\t"  + to_string(this->value) + "\n";
    itemOut +=  " Weight:\t"  + to_string(this->weight) + "\n";
    return itemOut;
}

Item Item::operator+(const Item& i){
    int value = this->value + i.value;
    Item n = Item("coins", "A small collection of coins", value, 10, false, false);
    return n;
}
Item Item::operator-(const Item& i){
    int value = this->value - i.value;
    Item n = Item("coins", "A small collection of coins", value, 10, false, false);
    return n;
}

package io.bna.ccibook.animalshelter;

/**
 * Created by brand on 11/4/2016.
 */
class PetNode {
    Integer id;
    PetType type;
    PetNode next = null;
    PetNode prev = null;
    PetNode nextSame = null;
    PetNode prevSame = null;

    PetNode(Integer id, PetType type) {
        this.id = id;
        this.type = type;
    }
}

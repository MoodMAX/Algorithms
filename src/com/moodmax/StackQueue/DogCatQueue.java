package com.moodmax.StackQueue;


import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;

class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}

class Dog extends Pet {
    public Dog() {
        super("dog");
    }
}

class Cat extends Pet {
    public Cat() {
        super("cat");
    }
}

class PetEnterQueue {
    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return this.pet;
    }

    public long getCount() {
        return this.count;
    }

    public String getEnterPetType() {
        return this.pet.getType();
    }
}

public class DogCatQueue {

    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    public DogCatQueue() {
        this.dogQ = new LinkedList<PetEnterQueue>();
        this.catQ = new LinkedList<PetEnterQueue>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if(pet.getType().equals("dog")) {
            this.dogQ.add(new PetEnterQueue(pet, this.count++));
        } else if (pet.getType().equals("cat")) {
            this.catQ.add(new PetEnterQueue(pet, this.count++));
        } else {
            throw new RuntimeException("error, not dog or cat.");
        }
    }

    public Pet pollAll() {
        if(!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
            if(this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
                return this.dogQ.poll().getPet();
            } else {
                return this.catQ.poll().getPet();
            }
        } else if (!this.dogQ.isEmpty()) {
            return this.dogQ.poll().getPet();
        } else if (!this.catQ.isEmpty()) {
            return this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("error, queue is empty.");
        }
    }

    public Dog pollDog() {
        if(!this.isDogQueueEmpty()) {
            return (Dog) this.dogQ.poll().getPet();
        } else {
            throw new RuntimeException("dog queue is empty.");
        }
    }

    public Cat pollCat() {
        if (!this.isCatQueueEmpty()) {
            return (Cat) this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("error, cat queue is empty.");
        }
    }

    public boolean isEmpty() {
        return this.catQ.isEmpty() && this.dogQ.isEmpty();
    }

    public boolean isDogQueueEmpty() {
        return this.dogQ.isEmpty();
    }

    public boolean isCatQueueEmpty() {
        return this.catQ.isEmpty();
    }

    // test samples
    public static void main(String[] args) {
        Dog pet1 = new Dog();
        Cat pet2 = new Cat();
        Cat pet3 = new Cat();
        Dog pet4 = new Dog();
        Dog pet5 = new Dog();
        Pet pet6 = new Dog();

        DogCatQueue queue = new DogCatQueue();

        queue.add(pet1);
        queue.add(pet2);
        queue.add(pet3);
        queue.add(pet4);
        queue.add(pet5);
        queue.add(pet6);

        System.out.println(queue.pollAll().getType());
        System.out.println(queue.pollAll().getType());
        System.out.println(queue.pollAll().getType());
        System.out.println(queue.pollAll().getType());
        System.out.println(queue.pollAll().getType());
        System.out.println(queue.pollAll().getType());;
    }
}


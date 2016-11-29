package main.server.model;

import java.io.Serializable;

public class Monster extends BaseCharacter implements Serializable{
	private static final long serialVersionUID = 1L;
	private int maxDamage;
	private String name;
	private boolean dead;
	public Monster(int hp, int level, int exp, int maxHP, int maxDamage, String name){
		super(hp, level, exp, maxDamage, 10);
		this.maxDamage = maxDamage;
		this.name = name;
	}

	/**
	 * Reduz a vida do monstro
	 * @param amount: dano recebido
	 * @return hp atual
	 */
	public int receiveDamage(int amount){
		hp-= amount;
		if(hp<=0)
			dead = true;
		
		return hp;
	}
	
	public String getName(){
		return name;
	}
	
	public int getMaxDamage(){
		return maxDamage;
	}

	public boolean isDead() {
		return dead;
	}
}

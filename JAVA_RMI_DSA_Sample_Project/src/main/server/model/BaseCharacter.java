package main.server.model;

import java.io.Serializable;

public class BaseCharacter implements Serializable{

	private static final long serialVersionUID = 1L;
	protected int hp;
	protected int level;
	protected int exp;
	protected int maxHP;
	protected int damage;
	
	
	public BaseCharacter(int hp, int level, int exp, int maxHP, int damage) {
		this.hp = hp;
		this.level = level;
		this.exp = exp;
		this.maxHP = maxHP;
		this.damage = damage;
	}

	//region gettersetter
		public int getHp() {
			return hp;
		}

		public int getLevel() {
			return level;
		}

		public int getExp() {
			return exp;
		}
		
		public void setMaxHP(int maxHP){
			this.maxHP = maxHP;
		}

		public int getDamage() {
			return damage;
		}

		public void setDamage(int damage) {
			this.damage = damage;
		}

		
		
		//endregion
}

package main.server.model;

import java.io.Serializable;

public class Player extends BaseCharacter implements Serializable {
	private static final long serialVersionUID = 1L;
	private int money;
	private int potion;
	private Monster currentEnemy;
	private int potionMaxHeal;
	private boolean dead;
	private String name;

	public Player(){
		super(100, 0, 0, 100,20);
		this.money = 0;
		this.potion = 0;
		this.potionMaxHeal = 20;
	}

	/**
	 * Reduz a vida do player
	 * @param amount: dano recebido
	 * @return hp atual
	 */
	public int receiveDamage(int amount){
		hp-= amount;
		if(hp<=0)
			dead = true;

		return hp;
	}

	/**
	 * Aumenta a vida do player
	 * @param amount: quanidade de vida a aumentar
	 * @return vida atual 
	 */
	public int healHP(int amount){
		hp += amount;
		if(hp > maxHP)
			hp = 100;
		return hp;
	}

	/**
	 * Adiciona experiencia ao player
	 * @param amount: quantidade de experiencia
	 * @return levelAtual
	 */
	public int addExp(int amount){
		this.exp += amount;
		return checkLevel(exp);
	}

	/**
	 * Verifica a experiencia atual
	 * @param exp: experiencia atual
	 * @return 
	 */
	private int checkLevel(int exp) {
		if(exp%100 == 0) {
			level = exp/100;
		}
		return level;
	}

	/**
	 * Aumenta o dinheiro do jogador
	 * @param amount: quantidade para auemntar
	 * @return total final
	 */
	public int increaseMoney(int amount){
		this.money += amount;
		return money;
	}

	/**
	 * Compra potion
	 * @return -1: se não houver dinheiro
	 * @return total de potion
	 */
	public int buyPotion(){
		if(money < 50)
			return -1;
		this.potion++;
		return potion;
	}

	/**
	 * Usa uma pocao
	 * @return -1: se não houver pocao
	 * @return novoHP
	 */
	public int usePotion(){
		if(potion == 0)
			return -1;
		this.potion--;
		this.hp += potionMaxHeal;
		return hp;
	}

	/**
	 * Define o inimigo
	 * @param enemy
	 */
	public void startBattle(Monster enemy){
		this.currentEnemy = enemy;
	}

	/**
	 * Ataca o inimigo e também é atacado por ele
	 * @return valor do dano causado pelo inimigo
	 */
	public Pair<Integer,Integer> attackEnemy(){
		//L: Ataque feito pelo player
		//R: Ataque feito pelo inimigo
		Pair<Integer,Integer> attackResult = new Pair<Integer, Integer>(currentEnemy.receiveDamage(damage), receiveDamage(currentEnemy.getDamage()));
		return attackResult;
	}

	public int getMoney() {
		return money;
	}

	public int getPotion() {
		return potion;
	}

	public Monster getCurrentEnemy() {
		return currentEnemy;
	}

	public boolean inBattle() {
		if(currentEnemy != null)
			return true;
		return false;

	}

	/**
	 * Finaliza a batalha
	 */
	public void finishBattle() {
		currentEnemy = null;
	}

	public boolean isDead() {
		return dead;
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
}

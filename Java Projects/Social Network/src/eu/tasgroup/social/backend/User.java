package eu.tasgroup.social.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
	private final String username;
	private final String nome;
	private int età;
	private final Set<User> amici;
	private final List<Post> post;

	public User(String username, String nome, int età) {
		this.username = username;
		this.nome = nome;
		this.età = età;
		this.amici = new HashSet<User>();
		this.post = new ArrayList<Post>();
	}

	public String getUsername() {
		return username;
	}

	public String getNome() {
		return nome;
	}

	public int getEtà() {
		return età;
	}

	public Set<User> getAmici() {
		return Collections.unmodifiableSet(this.amici);
	}

	public List<Post> getPost() {
		return Collections.unmodifiableList(this.post);
	}

	public void aggiungiPost(Post post) {
		this.post.add(post);
	}

	public void aggiungiAmico(User user) {
		this.amici.add(user);
	}

	public void rimuoviAmico(User user) {
		this.amici.remove(user);
	}
}

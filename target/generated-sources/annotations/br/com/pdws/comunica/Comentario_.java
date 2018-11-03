package br.com.pdws.comunica;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Comentario.class)
public abstract class Comentario_ {

	public static volatile SingularAttribute<Comentario, String> texto;
	public static volatile SingularAttribute<Comentario, Aluno> aluno;
	public static volatile SingularAttribute<Comentario, Long> ID;
	public static volatile SingularAttribute<Comentario, Comunicado> comunicado;

}


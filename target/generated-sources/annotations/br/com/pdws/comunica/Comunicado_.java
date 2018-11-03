package br.com.pdws.comunica;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Comunicado.class)
public abstract class Comunicado_ {

	public static volatile SingularAttribute<Comunicado, String> texto;
	public static volatile SingularAttribute<Comunicado, Professor> professor;
	public static volatile SingularAttribute<Comunicado, Long> ID;
	public static volatile ListAttribute<Comunicado, Comentario> comentarios;
	public static volatile CollectionAttribute<Comunicado, String> tags;

}


package br.com.pdws.comunica;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Aluno.class)
public abstract class Aluno_ extends br.com.pdws.comunica.Usuario_ {

	public static volatile SingularAttribute<Aluno, String> matricula;
	public static volatile ListAttribute<Aluno, Comentario> comentarios;

}


package br.com.pdws.comunica;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Professor.class)
public abstract class Professor_ extends br.com.pdws.comunica.Usuario_ {

	public static volatile SingularAttribute<Professor, String> siape;
	public static volatile ListAttribute<Professor, Comunicado> comunicados;

}


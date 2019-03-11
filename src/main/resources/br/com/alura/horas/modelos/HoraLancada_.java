package br.com.alura.horas.modelos;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-12-05T10:00:12.687-0200")
@StaticMetamodel(HoraLancada.class)
public class HoraLancada_ {
	public static volatile SingularAttribute<HoraLancada, Long> id;
	public static volatile SingularAttribute<HoraLancada, Calendar> data;
	public static volatile SingularAttribute<HoraLancada, String> horaInicial;
	public static volatile SingularAttribute<HoraLancada, String> horaFinal;
	public static volatile SingularAttribute<HoraLancada, Usuario> usuario;
}

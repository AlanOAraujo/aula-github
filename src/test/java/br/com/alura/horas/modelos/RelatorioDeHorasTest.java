package br.com.alura.horas.modelos;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class RelatorioDeHorasTest {

	@Test
	public void calculaRelatorioQuandoDatasSaoIguais() {
		Calendar data = new GregorianCalendar(2018, 12, 05);
		HoraLancada horaLancada = novaHoraLancada("10:00", "18:00", data);
		HoraLancada horaLancadaw = novaHoraLancada("10:00", "19:00", data);
		
		RelatorioDeHora relatoria = new RelatorioDeHora(Arrays.asList(horaLancada, horaLancadaw));
		
		List<HoraPorDia> horasPorDia = relatoria.getHorasPorDias();
		
		Assert.assertEquals(1, horasPorDia.size());
		HoraPorDia horasDia =  horasPorDia.get(0);
		
		Assert.assertEquals(8.0, horasDia.getHorasNormais(), 0.01);
		Assert.assertEquals(2.0, horasDia.getHorasExtras(), 0.01);
		
	}
	
	@Test
	public void calculaRelatorioQuandoDatasSaoDiferentes() {
		Calendar data1 = new GregorianCalendar(2018, 12, 05);
		Calendar data2 = new GregorianCalendar(2018, 12, 05);
		HoraLancada hora1 = novaHoraLancada("10:00", "18:00", data1);
		HoraLancada hora2 = novaHoraLancada("10:00", "20:00", data2);
		
		RelatorioDeHora relatoria = new RelatorioDeHora(Arrays.asList(hora1, hora2));
		
		List<HoraPorDia> horasPorDia = relatoria.getHorasPorDias();
		
		Assert.assertEquals(2, horasPorDia.size());
		HoraPorDia horasDia =  horasPorDia.get(0);
		
		Assert.assertEquals(8.0, horasDia.getHorasNormais(), 0.01);
		Assert.assertEquals(0.0, horasDia.getHorasExtras(), 0.01);
		
		
		HoraPorDia horasDia2 =  horasPorDia.get(1);
		
		Assert.assertEquals(8.0, horasDia2.getHorasNormais(), 0.01);
		Assert.assertEquals(0.0, horasDia2.getHorasExtras(), 0.01);
		
	}

	private HoraLancada novaHoraLancada(String horaFinal, String horaInicial, Calendar data) {

		HoraLancada horaLancada = new HoraLancada();
		horaLancada.setData(data);
		horaLancada.setHoraFinal(horaFinal);
		horaLancada.setHoraInicial(horaInicial);
		return horaLancada;
	}
	
	
	
}

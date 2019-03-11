package br.com.alura.horas.modelos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RelatorioDeHora {

	private List<HoraLancada> horasLancadas;
	private List<HoraPorDia> horasPorDias = new ArrayList<>();

	public RelatorioDeHora(List<HoraLancada> horasLancadas) {
		calculaHorasPorDia(horasLancadas);
	}

	private void calculaHorasPorDia(List<HoraLancada> horasLancadas) {
		if(!horasLancadas.isEmpty()) {
			double horasDoDia = 0.0;
			Calendar dataAtual = horasLancadas.get(0).getData();
			for (HoraLancada horaLancada : horasLancadas) {
				if(!horaLancada.getData().equals(dataAtual)) {
					double horasNormais = Math.min(8.0, horasDoDia);
					double horasExtras = Math.max(horasDoDia - 8, 0);
					HoraPorDia horaPorDia = new HoraPorDia(horasNormais, horasExtras, dataAtual);
					this.horasPorDias.add(horaPorDia);
					dataAtual = horaLancada.getData();
					horasDoDia = 0.0;
				}
				horasDoDia += horaLancada.getDuracao();
			}
			double horasNormais = Math.min(8.0, horasDoDia);
			double horasExtras = Math.max(horasDoDia - 8, 0);
			HoraPorDia horaPorDia = new HoraPorDia(horasNormais, horasExtras, dataAtual);
			this.horasPorDias.add(horaPorDia);
		}
	}

	public List<HoraLancada> getHorasLancadas() {
		return horasLancadas;
	}

	public void setHorasLancadas(List<HoraLancada> horasLancadas) {
		this.horasLancadas = horasLancadas;
	}

	public List<HoraPorDia> getHorasPorDias() {
		return horasPorDias;
	}

	public void setHorasPorDias(List<HoraPorDia> horasPorDias) {
		this.horasPorDias = horasPorDias;
	}
}

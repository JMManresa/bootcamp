package com.capgemini;

import com.capgemini.Enum.Color;

public class Juego {

	private Tablero tablero;
	private Color turno;
	private boolean partidaActiva = false;

	public Tablero GetTablero() throws JuegoException {
		if (!partidaActiva)
			throw new JuegoException("La partida aun no ha comenzado.");
		return tablero.Clone();
	}

	public Color GetTurno() throws JuegoException {
		if (!partidaActiva)
			throw new JuegoException("La partida aun no ha comenzado.");
		return turno;
	}

	public void Jugada(String jugada) throws JuegoException {
		if (!partidaActiva)
			throw new JuegoException("La partida aun no ha comenzado.");

		Movimiento movimiento = new Movimiento(jugada);
		Mover(movimiento);
	}

	private void Mover(Movimiento movimiento) throws JuegoException {

		Pieza pieza = tablero.GetEscaque(movimiento.GetPosicionInicial());

		if (pieza.GetColor() != GetTurno())
			throw new JuegoException("No puedes mover las piezas del rival.");

		int columnaFin = movimiento.GetPosicionFinal().GetColumna(), filaFin = movimiento.GetPosicionFinal().GetFila();

		if (tablero.HayPieza(columnaFin, filaFin)) {
			if (tablero.GetEscaque(columnaFin, filaFin).GetColor() != pieza.GetColor()) { // Hay pieza enemiga
				// validar movimiento
				if (!pieza.EsValido(movimiento, tablero))
					throw new JuegoException("Movimiento no valido para esta pieza");
				
				tablero.QuitaPieza(columnaFin, filaFin); 
				pieza.Mover(movimiento, tablero);
			} else { // ya hay una pieza del mismo color
				throw new JuegoException("Ya tienes una pieza en esa posicion");
			}
		} else { // la casilla está libre
			pieza.Mover(movimiento, tablero);
		}

		CambiaTurno();
	}

	private void CambiaTurno() {
		if (turno == Color.BLANCO)
			turno = Color.NEGRO;
		else
			turno = Color.BLANCO;
	}

	public void Inicializar() throws JuegoException {
		Tablero tablero = new Tablero();

		tablero.SetEscaque(1, 1, new Torre(Color.BLANCO));
		tablero.SetEscaque(2, 1, new Caballo(Color.BLANCO));
		tablero.SetEscaque(3, 1, new Alfil(Color.BLANCO));
		tablero.SetEscaque(4, 1, new Dama(Color.BLANCO));
		tablero.SetEscaque(5, 1, new Rey(Color.BLANCO));
		tablero.SetEscaque(6, 1, new Alfil(Color.BLANCO));
		tablero.SetEscaque(7, 1, new Caballo(Color.BLANCO));
		tablero.SetEscaque(8, 1, new Torre(Color.BLANCO));
		tablero.SetEscaque(1, 2, new Peon(Color.BLANCO));
		tablero.SetEscaque(2, 2, new Peon(Color.BLANCO));
		tablero.SetEscaque(3, 2, new Peon(Color.BLANCO));
		tablero.SetEscaque(4, 2, new Peon(Color.BLANCO));
		tablero.SetEscaque(5, 2, new Peon(Color.BLANCO));
		tablero.SetEscaque(6, 2, new Peon(Color.BLANCO));
		tablero.SetEscaque(7, 2, new Peon(Color.BLANCO));
		tablero.SetEscaque(8, 2, new Peon(Color.BLANCO));

		tablero.SetEscaque(1, 8, new Torre(Color.NEGRO));
		tablero.SetEscaque(2, 8, new Caballo(Color.NEGRO));
		tablero.SetEscaque(3, 8, new Alfil(Color.NEGRO));
		tablero.SetEscaque(4, 8, new Dama(Color.NEGRO));
		tablero.SetEscaque(5, 8, new Rey(Color.NEGRO));
		tablero.SetEscaque(6, 8, new Alfil(Color.NEGRO));
		tablero.SetEscaque(7, 8, new Caballo(Color.NEGRO));
		tablero.SetEscaque(8, 8, new Torre(Color.NEGRO));
		tablero.SetEscaque(1, 7, new Peon(Color.NEGRO));
		tablero.SetEscaque(2, 7, new Peon(Color.NEGRO));
		tablero.SetEscaque(3, 7, new Peon(Color.NEGRO));
		tablero.SetEscaque(4, 7, new Peon(Color.NEGRO));
		tablero.SetEscaque(5, 7, new Peon(Color.NEGRO));
		tablero.SetEscaque(6, 7, new Peon(Color.NEGRO));
		tablero.SetEscaque(7, 7, new Peon(Color.NEGRO));
		tablero.SetEscaque(8, 7, new Peon(Color.NEGRO));

		partidaActiva = true;
		turno = Color.BLANCO;
	}

	private void PromocionarPeon(Object o) {
		// TODO
	}
}

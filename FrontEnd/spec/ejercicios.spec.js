describe("Pruebas de los ejercicios", () => {
  describe("Ejercicio 1", () => {
    describe("OK", () => {
      it("Genera aleatorio", () => {
        let num = numeroAleatorioEntre(1, 100);
        expect(num).toBeGreaterThanOrEqual(1);
        expect(num).toBeLessThanOrEqual(100);
      });
    });
  });

  describe("Ejercicio 3", () => {
    describe("OK", () => {
      it("Crea array", () => {
        let array = devolverArray(4, 2);
        expect(array).toEqual([2, 2, 2, 2]);

        array = devolverArray(5);
        expect(array).toEqual([0, 0, 0, 0, 0]);

        array = devolverArray(10, 5);
        expect(array).toEqual([5, 5, 5, 5, 5, 5, 5, 5, 5, 5]);
      });
    });
  });

  describe("Ejercicio 4", () => {
    describe("OK", () => {
      it("Numeros primos", () => {
        let nPrimos = numerosPrimos(3);
        expect(nPrimos).toEqual([2,3,5]);

        nPrimos = numerosPrimos(1);
        expect(nPrimos).toEqual([2]);

        nPrimos = numerosPrimos(10);
        expect(nPrimos).toEqual([2,3,5,7,11,13,17,19,23,29]);
      });
    });
  });
});

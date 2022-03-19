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

  describe("Ejercicio 2", () => {
    it("Pendiente");
  });
});

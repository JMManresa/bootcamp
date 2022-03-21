describe("Pruebas calculadora", () => {
    describe("Suma", () => {
        describe("OK", () => {
            it("Suma enteros", () => {
                let pantallaPrincipal = {textContent: 10};
                let pantallaSecundaria = {textContent: 10};
                let calculadora = new Calculadora(pantallaPrincipal, pantallaSecundaria);
                calculadora.resetear();
                expect(pantallaPrincipal.textContent).toBe(0);
                expect(pantallaSecundaria.textContent).toBe("");
                calculadora.imprimirEnPrincipal("2");
                calculadora.calcula("+");
                calculadora.imprimirEnPrincipal("2");
                calculadora.calcula("+");
                expect(pantallaPrincipal.textContent).toBe(4);
            });
        });
    });
});
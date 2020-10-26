<template>
  <div id="stock">
    <div id="page-product">
      <div id="container">
        <header class="page-header">
          <div class="top-bar-container">
            <router-link to="/login">
              <img src="assets/back.svg" alt="Voltar" />
            </router-link>
            <img src="assets/logo.png" alt="Teixeira Móveis" />
          </div>

          <div class="header-content">
            <strong>Esses são os nossos móveis disponíveis</strong>
            <form id="search-product">
              <div class="select-block">
                <label for="order">Ordenar</label>
                <select name="order" id="order">
                  <option value="" disabled="" hidden="">ordem</option>
                  <option value="1">Relevância</option>
                  <option value="1">Menor preço</option>
                  <option value="2">Maior preço</option>
                </select>
              </div>
              <div class="select-block">
                <label for="products">Produtos</label>
                <select name="products" id="products">
                  <option value="" disabled="" hidden="">
                    Selecione uma opção
                  </option>
                  <option value="0">Mesa</option>
                  <option value="1">Cama</option>
                  <option value="2">Guarda roupa</option>
                  <option value="3">Sofá</option>
                  <option value="4">Penteadeira</option>
                  <option value="5">Cadeiras</option>
                </select>
              </div>
              <button type="submit">Filtrar</button>
            </form>
          </div>
        </header>

        <main>
          <article class="stock-item">
            <header>
              <img
                src="https://a-static.mlcdn.com.br/352x470/mesa-de-jantar-6-lugares-copenhage-nogueira-dakota-viero-moveis/panoramamoveis/41910/445e79f2e72245e091715950a6e88ccc.jpg"
                alt="Mesa de jantar completa"
              />
              <div>
                <strong>Mesa De Jantar 6 Lugares</strong>
                <span>N° de série: 89604a5a</span>
              </div>
            </header>

            <p>
              <strong>Descrição:</strong>
              Mesa de madeira com acabamento refinado, composta por MDP e MDF de
              15 mm.
              <br /><br />
              <strong>Tipo de produto:</strong> sala.<br /><br />
              <strong>Quantidade:</strong> 2 unidades em estoque.<br />
            </p>

            <footer>
              <p>Preço do produto:<strong>R$ 816,81 à vista</strong></p>

              <button type="button">
                <router-link to="/login">
                  <img
                    src="https://image.flaticon.com/icons/png/512/23/23258.png"
                    alt="carrinho de compras"
                  />Adicionar ao carrinho
                </router-link>
              </button>
            </footer>
          </article>
        </main>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Produtos",
};
</script>

<style>
:root {
  /*variáveis*/
  --color-background: #f0f0f7;
  --color-primary-lighter: #4865e6;
  --color-primary-light: #3051e2;
  --color-primary: #101444;
  --color-primary-dark: #774dd6;
  --color-primary-darker: #6842c2;
  --color-secondary: #04d361;
  --color-secondary-dark: #04bf58;
  --color-title-in-primary: #ffffff;
  --color-text-in-primary: #d4c2ff;
  --color-text-title: #32264d;
  --color-text-complement: #9c98a6;
  --color-text-base: #6a6180;
  --color-line-in-white: #e6e6f0;
  --color-input-background: #f8f8fc;
  --color-button-text: #ffffff;
  --color-box-base: #ffffff;
  --color-box-footer: #fafafc;
  --color-small-info: #c1bccc;
  /*tamanho da fonte padrão: 16px - 100% - 1rem*/
  font-size: 60%; /* controle das medidas rem */
}

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

html,
#app #page-landing {
  height: 100vh;
}

#app #page-landing,
#reapp body,
#stock,
#furniture {
  background: var(--color-background);
  display: flex;
  align-items: center;
  justify-content: center;
}

#app body,
#reapp,
#stock,
#furniture,
input,
button,
textarea,
#page-customer-registration {
  /* font: 500 1.6rem Poppins; */
  font-weight: 500;
  font-family: Poppins;
  font-size: 1.6rem;
  color: var(--color-text-base);
}

#app #page-landing #container {
  width: 90vw;
  max-width: 700px;
}

@media (min-width: 700px) {
  :root {
    font-size: 62.5%; /*Todo 1rem vai ser relativo a 10px*/
  }
}

.page-header {
  background-color: var(--color-primary);

  display: flex;
  flex-direction: column;
}

.page-header .top-bar-container {
  width: 90%;
  margin: 0 auto;

  display: flex;
  align-items: center;
  justify-content: space-between;

  padding: 1.6rem;
}

.page-header .top-bar-container a {
  height: 3.2rem;
  transition: opacity 0.2s;
}

.page-header .top-bar-container a:hover {
  opacity: 0.6;
}

.page-header .top-bar-container > img {
  height: 3.2rem;
}

.page-header .header-content {
  width: 90%;
  margin: 3.2rem auto;

  position: relative;
}

.page-header .header-content strong {
  font: 700 3.6rem Archivo;
  line-height: 4.2rem;
  color: var(--color-title-in-primary);
}

.page-header .header-content p {
  max-width: 30rem;
  font-size: 1.6rem;
  line-height: 2.6rem;
  color: var(--color-text-in-primary);
  margin-top: 2.4rem;
}

@media (min-width: 700px) {
  .page-header {
    height: 340px;
  }

  .page-header .top-bar-container {
    max-width: 1100px;
  }

  .page-header .header-content {
    max-width: 740px;

    margin: 0 auto;

    flex: 1 1;
    padding-bottom: 48px;
    display: flex;
    flex-direction: column;
    justify-content: center;
  }

  .page-header .header-content strong {
    max-width: 350px;
  }
}

.select-block label,
input-block label,
.textarea-block label {
  font-size: 1.4rem;
  color: var(--color-text-complement);
}

.input-block input,
.select-block select,
.textarea-block textarea {
  width: 100%;
  height: 5.6rem;
  margin-top: 0.8rem;
  border-radius: 0.8rem;
  background: var(--color-input-background);
  border: 1px solid var(--color-line-in-write);
  outline: 0;
  padding: 0 1.6rem;
  font: 1.6rem Archivo;
}

.textarea-block textarea {
  padding: 1.2rem 1.6rem;
  height: 16rem;

  resize: vertical;
}

.input-block,
.textarea-block {
  position: relative;
}

.input-block:focus-within::after,
.textarea-block:focus-within::after {
  content: "";

  width: calc(100% - 3.2rem);
  height: 2px;
  background: var(--color-primary-light);

  position: absolute;
  left: 1.6rem;
  right: 1.6rem;
  bottom: 0px;
}
#page-product #container {
  width: 100vw;
  height: 100vh;
}

#search-product {
  margin-top: 3.2rem;
}

#search-product label {
  color: var(--color-text-in-primary);
}

#search-product .select-block {
  margin-bottom: 1.4rem;
}

#search-product button {
  width: 100%;
  height: 5.6rem;
  background: var(--color-secondary);
  color: var(--color-button-text);
  border: 0;
  border-radius: 0.8rem;
  cursor: pointer;
  font: 700 1.6rem Archivo;
  display: flex;
  align-items: center;
  justify-content: center;

  transition: background 0.2s;
  margin-top: 3.2rem;
}

#search-product button:hover {
  background-color: var(--color-secondary-dark);
}

#page-product main {
  margin: 3.2rem auto;
  width: 90%;
}

.stock-item {
  background-color: var(--color-box-base);
  border: 1px solid var(--color-line-in-white);
  border-radius: 0.8rem;
  margin-top: 2.4rem;
}

.stock-item header {
  padding: 3.2rem;
  display: flex;
  align-items: center;
}

.stock-item header img {
  width: 25rem;
  height: 25rem;
  border-radius: 2%;
}

.stock-item header div {
  margin-left: 2.4rem;
}

.stock-item header div strong {
  font: 700 2.4rem Archivo;
  display: block;
  color: var(--color-text-title);
}

.stock-item header div span {
  font-size: 1.6rem;
  display: block;
  margin-top: 0.4rem;
}

.stock-item > p {
  padding: 0 2rem;
  font-size: 1.6rem;
  line-height: 2.8rem;
}

.stock-item footer {
  padding: 3.2rem 2rem;
  background-color: var(--color-box-footer);
  border-top: 1px solid var(--color-line-in-white);
  margin-top: 3.2rem;

  display: flex;
  align-items: center;
  justify-content: space-between;
}

.stock-item footer p {
  font-size: 1.4rem;
  line-height: 2.4rem;
  color: var(--color-text-complement);
}

.stock-item footer p strong {
  font-size: 1.6rem;
  color: var(--color-primary);
  display: block;
}
.stock-item footer button img {
  width: 25px;
  height: 25px;
}

.stock-item footer button {
  width: 20rem;
  height: 5.6rem;
  background: var(--color-secondary);
  color: var(--color-button-text);
  border: 0;
  border-radius: 0.8rem;
  cursor: pointer;
  font: 700 1.4rem Archivo;

  display: flex;
  align-items: center;
  justify-content: space-evenly;

  text-decoration: none;

  transition: background 0.2s;
  margin-left: 1.6rem;
}
.stock-item footer a {
  width: 20rem;
  height: 5.6rem;

  color: var(--color-button-text);
  border: 0;
  border-radius: 0.8rem;
  cursor: pointer;
  font: 700 1.4rem Archivo;

  display: flex;
  align-items: center;
  justify-content: space-evenly;

  text-decoration: none;
}

.stock-item footer button:hover {
  background: var(--color-secondary-dark);
}

@media (min-width: 700px) {
  #page-product #container {
    max-width: 100vw;
  }

  .page-header {
    height: 340px;
  }

  .page-header .top-bar-container {
    max-width: 1100px;
  }

  .page-header .header-content {
    max-width: 740px;

    margin: 0 auto;

    flex: 1 1;
    padding-bottom: 48px;
    display: flex;
    flex-direction: column;
    justify-content: center;
  }

  .page-header .header-content strong {
    max-width: 350px;
  }

  .stock-item header,
  .stock-item footer {
    padding: 32px;
  }

  #search-product {
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    gap: 16px;
    position: absolute;
    bottom: -28px;
  }

  #page-product main {
    padding: 32px 0;
    max-width: 740px;
    margin: 0 auto;
  }

  #search-product .select-block {
    margin-bottom: 0;
  }

  .stock-item > p {
    padding: 0 32px;
  }

  .stock-item footer p strong {
    display: initial;
    margin-left: 16px;
  }

  .stock-item footer button {
    width: 245px;
    font-size: 16px;
    justify-content: center;
  }

  .stock-item footer button img {
    margin-right: 16px;
  }
}
</style>
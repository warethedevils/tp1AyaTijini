# TP 1 - Accès direct à l'API de Gemini (Aya Tijini)

Application Web (Jakarta EE 11, JSF/PrimeFaces) qui envoie la question de l'utilisateur à l'API REST de Gemini
**sans librairie** (client JAX-RS + JSON-P) et affiche la réponse. Le mode « debug » montre les JSON échangés.

## Architecture

| Classe | Rôle |
|---|---|
| `jsf.Bb` | Backing bean (portée view) de `index.xhtml`. Délègue à `JsonAdapterPourGemini`. |
| `llm.JsonAdapterPourGemini` | Construit/lit le JSON, **conserve l'historique de la conversation** (API sans état). |
| `llm.LlmClientPourGemini` | Client REST : lit la clé dans la variable `GEMINI_KEY`, envoie le POST. |
| `llm.LlmInteraction` | Record `(questionJson, reponseJson, reponseExtraite)`. |
| `llm.RequeteException` | Levée si l'API répond avec un statut différent de 200. |

## Lancer

1. Définir la variable d'environnement utilisateur `GEMINI_KEY` (clé Google AI Studio), puis redémarrer Payara/IntelliJ.
2. `mvn clean package`, déployer `target/tp1AyaTijini-1.0-SNAPSHOT.war` sur Payara 7.
3. Ouvrir http://localhost:8080/tp1AyaTijini-1.0-SNAPSHOT/

Modèle utilisé : `gemini-3.5-flash-lite` (voir `LlmClientPourGemini`).

## Rôle système bonus

« Détective de Casablanca » : le LLM répond comme Sam Barka, détective privé de la médina dans les années 1950
(ton film noir), et termine par « Affaire classée. » suivi d'un indice.

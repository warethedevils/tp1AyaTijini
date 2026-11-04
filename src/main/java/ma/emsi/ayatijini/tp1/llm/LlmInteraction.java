package ma.emsi.ayatijini.tp1.llm;

/**
 * Résultat d'un échange avec l'API du LLM.
 * Permet de retourner en une seule fois la réponse à afficher à l'utilisateur
 * et les textes JSON de la requête et de la réponse (affichés en mode "debug").
 *
 * @param questionJson   le texte JSON de la requête envoyée à l'API du LLM.
 * @param reponseJson    le texte JSON de la réponse reçue de l'API du LLM.
 * @param reponseExtraite le texte de la réponse, extrait du JSON de la réponse.
 */
public record LlmInteraction(String questionJson, String reponseJson, String reponseExtraite) {
}

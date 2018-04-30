<?php

/* project/delete.html.twig */
class __TwigTemplate_a23f7e21bf4132835fec405b5350f2d203714afcff87719f4845adc93353750d extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        // line 1
        $this->parent = $this->loadTemplate("base.html.twig", "project/delete.html.twig", 1);
        $this->blocks = array(
            'main' => array($this, 'block_main'),
        );
    }

    protected function doGetParent(array $context)
    {
        return "base.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        $__internal_c7f988518c1b501726aba2790baa3d266e7f7b3a403afd04a5c94448ae427358 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_c7f988518c1b501726aba2790baa3d266e7f7b3a403afd04a5c94448ae427358->enter($__internal_c7f988518c1b501726aba2790baa3d266e7f7b3a403afd04a5c94448ae427358_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "project/delete.html.twig"));

        $__internal_879049a67359c66ab5ee5254032186fe4f1061be8a5c68f39e3ac061f1118df0 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_879049a67359c66ab5ee5254032186fe4f1061be8a5c68f39e3ac061f1118df0->enter($__internal_879049a67359c66ab5ee5254032186fe4f1061be8a5c68f39e3ac061f1118df0_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "project/delete.html.twig"));

        $this->parent->display($context, array_merge($this->blocks, $blocks));
        
        $__internal_c7f988518c1b501726aba2790baa3d266e7f7b3a403afd04a5c94448ae427358->leave($__internal_c7f988518c1b501726aba2790baa3d266e7f7b3a403afd04a5c94448ae427358_prof);

        
        $__internal_879049a67359c66ab5ee5254032186fe4f1061be8a5c68f39e3ac061f1118df0->leave($__internal_879049a67359c66ab5ee5254032186fe4f1061be8a5c68f39e3ac061f1118df0_prof);

    }

    // line 3
    public function block_main($context, array $blocks = array())
    {
        $__internal_6f3e542a1b5f96a69fc55064de1147b7928b3cd050f224027f073175306549ea = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_6f3e542a1b5f96a69fc55064de1147b7928b3cd050f224027f073175306549ea->enter($__internal_6f3e542a1b5f96a69fc55064de1147b7928b3cd050f224027f073175306549ea_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "main"));

        $__internal_a0c5e7fe5b4e9096251730ca9d6203fdba1456ce360ff548daee88ab2aa06a52 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_a0c5e7fe5b4e9096251730ca9d6203fdba1456ce360ff548daee88ab2aa06a52->enter($__internal_a0c5e7fe5b4e9096251730ca9d6203fdba1456ce360ff548daee88ab2aa06a52_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "main"));

        // line 4
        echo "<div class=\"wrapper\">
    <form class=\"project-create\" method=\"post\">
        <div class=\"create-header\">
            Delete Project
        </div>
        <div class=\"create-title\">
            <div class=\"create-title-label\">Title</div>
            <input class=\"create-title-content\" name=\"project[title]\" value=\"";
        // line 11
        echo twig_escape_filter($this->env, $this->getAttribute(($context["project"] ?? $this->getContext($context, "project")), "title", array()), "html", null, true);
        echo "\" disabled=\"disabled\"/>
        </div>
        <div class=\"create-description\">
            <div class=\"create-description-label\">Description</div>
            <textarea rows=\"3\" class=\"create-description-content\" name=\"project[description]\"
                      disabled=\"disabled\">";
        // line 16
        echo twig_escape_filter($this->env, $this->getAttribute(($context["project"] ?? $this->getContext($context, "project")), "description", array()), "html", null, true);
        echo "</textarea>
        </div>
        <div class=\"create-budget\">
            <div class=\"create-budget-label\">Budget</div>
            <input type=\"number\" min=\"0\" class=\"create-budget-content\" name=\"project[budget]\" value=\"";
        // line 20
        echo twig_escape_filter($this->env, $this->getAttribute(($context["project"] ?? $this->getContext($context, "project")), "budget", array()), "html", null, true);
        echo "\"
                   disabled=\"disabled\"/>
        </div>
        <div class=\"create-button-holder\">
            <button type=\"submit\" class=\"submit-button\">Delete Project</button>
            <a type=\"button\" href=\"/\" class=\"back-button\">Back</a>
        </div>

        ";
        // line 28
        echo $this->env->getRuntime('Symfony\Bridge\Twig\Form\TwigRenderer')->searchAndRenderBlock($this->getAttribute(($context["form"] ?? $this->getContext($context, "form")), "_token", array()), 'row');
        echo "
    </form>
</div>
";
        
        $__internal_a0c5e7fe5b4e9096251730ca9d6203fdba1456ce360ff548daee88ab2aa06a52->leave($__internal_a0c5e7fe5b4e9096251730ca9d6203fdba1456ce360ff548daee88ab2aa06a52_prof);

        
        $__internal_6f3e542a1b5f96a69fc55064de1147b7928b3cd050f224027f073175306549ea->leave($__internal_6f3e542a1b5f96a69fc55064de1147b7928b3cd050f224027f073175306549ea_prof);

    }

    public function getTemplateName()
    {
        return "project/delete.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  84 => 28,  73 => 20,  66 => 16,  58 => 11,  49 => 4,  40 => 3,  11 => 1,);
    }

    /** @deprecated since 1.27 (to be removed in 2.0). Use getSourceContext() instead */
    public function getSource()
    {
        @trigger_error('The '.__METHOD__.' method is deprecated since version 1.27 and will be removed in 2.0. Use getSourceContext() instead.', E_USER_DEPRECATED);

        return $this->getSourceContext()->getCode();
    }

    public function getSourceContext()
    {
        return new Twig_Source("{% extends \"base.html.twig\" %}

{% block main %}
<div class=\"wrapper\">
    <form class=\"project-create\" method=\"post\">
        <div class=\"create-header\">
            Delete Project
        </div>
        <div class=\"create-title\">
            <div class=\"create-title-label\">Title</div>
            <input class=\"create-title-content\" name=\"project[title]\" value=\"{{ project.title }}\" disabled=\"disabled\"/>
        </div>
        <div class=\"create-description\">
            <div class=\"create-description-label\">Description</div>
            <textarea rows=\"3\" class=\"create-description-content\" name=\"project[description]\"
                      disabled=\"disabled\">{{ project.description }}</textarea>
        </div>
        <div class=\"create-budget\">
            <div class=\"create-budget-label\">Budget</div>
            <input type=\"number\" min=\"0\" class=\"create-budget-content\" name=\"project[budget]\" value=\"{{ project.budget }}\"
                   disabled=\"disabled\"/>
        </div>
        <div class=\"create-button-holder\">
            <button type=\"submit\" class=\"submit-button\">Delete Project</button>
            <a type=\"button\" href=\"/\" class=\"back-button\">Back</a>
        </div>

        {{ form_row(form._token) }}
    </form>
</div>
{% endblock %}", "project/delete.html.twig", "C:\\Users\\NinoB\\Desktop\\teting\\app\\Resources\\views\\project\\delete.html.twig");
    }
}

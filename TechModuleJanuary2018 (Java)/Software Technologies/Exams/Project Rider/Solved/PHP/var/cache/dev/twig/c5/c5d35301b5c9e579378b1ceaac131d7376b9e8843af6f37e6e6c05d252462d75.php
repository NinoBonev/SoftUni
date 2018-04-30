<?php

/* project/index.html.twig */
class __TwigTemplate_497e553cb8a9876eabbdc24baeff1d92ba0322cc9692f44433c627072334235f extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        // line 1
        $this->parent = $this->loadTemplate("base.html.twig", "project/index.html.twig", 1);
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
        $__internal_197466a4ec41c84ed1cbdb6654edef55b1ac6ec236437ada833589bd9c4f4b03 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_197466a4ec41c84ed1cbdb6654edef55b1ac6ec236437ada833589bd9c4f4b03->enter($__internal_197466a4ec41c84ed1cbdb6654edef55b1ac6ec236437ada833589bd9c4f4b03_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "project/index.html.twig"));

        $__internal_893d96f75e7f5d9c9244c21a236bb7f175588ce35586db32bd9e2b58faa1e1f6 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_893d96f75e7f5d9c9244c21a236bb7f175588ce35586db32bd9e2b58faa1e1f6->enter($__internal_893d96f75e7f5d9c9244c21a236bb7f175588ce35586db32bd9e2b58faa1e1f6_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "project/index.html.twig"));

        $this->parent->display($context, array_merge($this->blocks, $blocks));
        
        $__internal_197466a4ec41c84ed1cbdb6654edef55b1ac6ec236437ada833589bd9c4f4b03->leave($__internal_197466a4ec41c84ed1cbdb6654edef55b1ac6ec236437ada833589bd9c4f4b03_prof);

        
        $__internal_893d96f75e7f5d9c9244c21a236bb7f175588ce35586db32bd9e2b58faa1e1f6->leave($__internal_893d96f75e7f5d9c9244c21a236bb7f175588ce35586db32bd9e2b58faa1e1f6_prof);

    }

    // line 3
    public function block_main($context, array $blocks = array())
    {
        $__internal_4173c3712309c6e2e921a718275e23ed1e3b03642bc65fbf4e08a2ee0a1cb83d = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_4173c3712309c6e2e921a718275e23ed1e3b03642bc65fbf4e08a2ee0a1cb83d->enter($__internal_4173c3712309c6e2e921a718275e23ed1e3b03642bc65fbf4e08a2ee0a1cb83d_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "main"));

        $__internal_e64ccf37b7e2322867817722524a93809f9c282f0760783d4ee0a9257282300c = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_e64ccf37b7e2322867817722524a93809f9c282f0760783d4ee0a9257282300c->enter($__internal_e64ccf37b7e2322867817722524a93809f9c282f0760783d4ee0a9257282300c_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "main"));

        // line 4
        echo "<div class=\"wrapper\">
    <div class=\"button-holder\">
        <a type=\"button\" href=\"/create\" class=\"log-button\">Create New Project</a>
    </div>
    <div class=\"content\">
        <div class=\"header\">
            <div class=\"project-label\">Project</div>
            <div class=\"budget-label\">Budget</div>
            <div class=\"actions-label\">Actions</div>
        </div>
        <div class=\"main\">
            ";
        // line 15
        $context['_parent'] = $context;
        $context['_seq'] = twig_ensure_traversable(($context["projects"] ?? $this->getContext($context, "projects")));
        foreach ($context['_seq'] as $context["_key"] => $context["project"]) {
            // line 16
            echo "                <div class=\"project\">
                    <div class=\"project-title\">
                        ";
            // line 18
            echo twig_escape_filter($this->env, $this->getAttribute($context["project"], "title", array()), "html", null, true);
            echo "
                    </div>
                    <div class=\"project-budget\">
                        ";
            // line 21
            echo twig_escape_filter($this->env, $this->getAttribute($context["project"], "budget", array()), "html", null, true);
            echo "
                    </div>
                    <div class=\"project-actions\">
                        <a type=\"button\" href=\"";
            // line 24
            echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\RoutingExtension')->getPath("edit", array("id" => $this->getAttribute($context["project"], "id", array()))), "html", null, true);
            echo "\" class=\"edit-button\">Edit</a>
                        <a type=\"button\" href=\"";
            // line 25
            echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\RoutingExtension')->getPath("delete", array("id" => $this->getAttribute($context["project"], "id", array()))), "html", null, true);
            echo "\" class=\"delete-button\">Delete</a>
                    </div>
                </div>
            ";
        }
        $_parent = $context['_parent'];
        unset($context['_seq'], $context['_iterated'], $context['_key'], $context['project'], $context['_parent'], $context['loop']);
        $context = array_intersect_key($context, $_parent) + $_parent;
        // line 29
        echo "        </div>
    </div>
</div>
";
        
        $__internal_e64ccf37b7e2322867817722524a93809f9c282f0760783d4ee0a9257282300c->leave($__internal_e64ccf37b7e2322867817722524a93809f9c282f0760783d4ee0a9257282300c_prof);

        
        $__internal_4173c3712309c6e2e921a718275e23ed1e3b03642bc65fbf4e08a2ee0a1cb83d->leave($__internal_4173c3712309c6e2e921a718275e23ed1e3b03642bc65fbf4e08a2ee0a1cb83d_prof);

    }

    public function getTemplateName()
    {
        return "project/index.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  96 => 29,  86 => 25,  82 => 24,  76 => 21,  70 => 18,  66 => 16,  62 => 15,  49 => 4,  40 => 3,  11 => 1,);
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
    <div class=\"button-holder\">
        <a type=\"button\" href=\"/create\" class=\"log-button\">Create New Project</a>
    </div>
    <div class=\"content\">
        <div class=\"header\">
            <div class=\"project-label\">Project</div>
            <div class=\"budget-label\">Budget</div>
            <div class=\"actions-label\">Actions</div>
        </div>
        <div class=\"main\">
            {% for project in projects %}
                <div class=\"project\">
                    <div class=\"project-title\">
                        {{ project.title }}
                    </div>
                    <div class=\"project-budget\">
                        {{ project.budget }}
                    </div>
                    <div class=\"project-actions\">
                        <a type=\"button\" href=\"{{ path('edit', {id: project.id}) }}\" class=\"edit-button\">Edit</a>
                        <a type=\"button\" href=\"{{ path('delete', {id: project.id}) }}\" class=\"delete-button\">Delete</a>
                    </div>
                </div>
            {% endfor %}
        </div>
    </div>
</div>
{% endblock %}", "project/index.html.twig", "C:\\Users\\NinoB\\Desktop\\teting\\app\\Resources\\views\\project\\index.html.twig");
    }
}
